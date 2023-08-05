package com.javarush.island.cooper.app;

import java.util.Map;
import java.util.HashMap;
import com.javarush.island.cooper.entity.*;
import com.javarush.island.cooper.services.*;
import com.javarush.island.cooper.system.Result;
import com.javarush.island.cooper.system.Settings;
import com.javarush.island.cooper.system.ResultCode;
import com.javarush.island.cooper.controller.Controller;
import com.javarush.island.cooper.constants.AppConstants;
import com.javarush.island.cooper.exception.AppException;

public class Application {
    private final Controller controller;
    private static volatile Map<String, Integer> appState = new HashMap<>();

    public Application(Controller controller) {
        this.controller = controller;
    }

    public void run() {
        controller.getView().start();
    }

    /**
     * Запуск симуляции
     * @param island - остров
     * @param settings - настройки
     */
    public static void startSimulation(Island island, Settings settings)  {
        try {
            int i = 0;
            do {
                if (i >= settings.getMaxCycles()) break;

                resetAppState();
                startService("die", island, settings);
                startService("eat", island, settings);
                startService("die", island, settings);
                startService("reproduce", island, settings);
                startService("die", island, settings);
                startService("move", island, settings);
                updateAppState(island);

                showResult(new Result(ResultCode.OK, "День " + (i + 1) + ". На острове живут - " + appState));
                i++;
            } while (isContinueSimulation(settings.getTerminationCondition(), getAppState()));

            showFinishResult(island);
        } catch (InterruptedException | AppException e) {
            showResult(new Result(ResultCode.ERROR, e.getMessage()));
        }
    }

    /**
     * Проверяет условие для продолжения симуляции
     * @param condition - условие остановки
     * @param appState - состояние острова (количество растений, травоядных и хищников)
     * @return
     */
    private static boolean isContinueSimulation(int condition, Map<String, Integer> appState) {
        return switch (condition) {
            case AppConstants.RESULT_NO_PLANT -> appState.get("Plant") > 0;
            case AppConstants.RESULT_NO_ANIMAL -> appState.get("Predator") + appState.get("Herbivore") > 0;
            case AppConstants.RESULT_NO_HERBIVORE -> appState.get("Herbivore") > 0;
            case AppConstants.RESULT_NO_PREDATOR -> appState.get("Predator") > 0;
            default -> throw new AppException("Неизвестное условие окончания симуляции: " + condition);
        };
    }

    /**
     * Запускает сервис в новом потоке
     * @param service - сервис
     * @param island - остров
     * @param settings - настройки
     * @throws InterruptedException
     */
    private static void startService(String service, Island island, Settings settings) throws InterruptedException {
        Simulation simulation;
        Thread serviceThread;

        simulation = getSimulation(service, island, settings);
        serviceThread = new Thread(simulation);
        serviceThread.start();
        serviceThread.join();
        Thread.sleep(1000);
    }

    /**
     * Возвращает объект симуляции
     * @param action - симуляция
     * @param island - остров
     * @param settings - настройки
     * @return
     */
    private static Simulation getSimulation(String action, Island island, Settings settings) {
        return switch (action) {
            case "eat" -> new Eat(island, settings);
            case "die" -> new Die(island, settings);
            case "reproduce" -> new Reproduce(island, settings);
            case "move" -> new Move(island, settings);
            case "show" -> new Show(island, settings);
            default -> new UnknownAction(island, settings);
        };
    }

    public static Map<String, Integer> getAppState() {
        return appState;
    }

    /**
     * Сбрасывает текущее состояние острова
     */
    public static void resetAppState() {
        appState.put("Plant", 0);
        appState.put("Predator", 0);
        appState.put("Herbivore", 0);
    }

    /**
     * Проверяет текущее состояние острова (количество растений, травоядных и хищников)
     * @param island - остров
     */
    public static void updateAppState(Island island) {
        for (Cell[] values : island.getCells()) {
            for (Cell cell : values) {
                for (Unit unit : cell.getUnitList()) {
                    if (unit instanceof Plant) appState.put("Plant", appState.get("Plant") + 1);
                    if (unit instanceof Predator) appState.put("Predator", appState.get("Predator") + 1);
                    if (unit instanceof Herbivore) appState.put("Herbivore", appState.get("Herbivore") + 1);
                }
            }
        }
    }

    /**
     * Выводит результаты в консоль
     * @param result - результат
     */
    public static void showResult(Result result) {
        switch (result.getResultCode()) {
            case ERROR -> System.out.println(AppConstants.ANSI_RED + result.getMessage() + AppConstants.ANSI_RESET);
            case FINISH -> System.out.println(AppConstants.ANSI_PURPLE + result.getMessage() + AppConstants.ANSI_RESET);
            case OK -> System.out.println(result.getMessage());
        }
    }

    /**
     * Выводит финальный результат (список всех клеток с количеством животных)
     * @param island
     */
    private static void showFinishResult(Island island) {
        Cell[][] cells = island.getCells();

        showResult(new Result(ResultCode.OK, AppConstants.DELIMITER));

        for (int y = 0; y < cells.length; y++) {
            for (int x = 0; x < cells[0].length; x++) {
                showResult(new Result(ResultCode.FINISH, "cell{" + y + ", " + x + "} - " + cells[y][x].getCountAnimals()));
            }
        }
    }
}
