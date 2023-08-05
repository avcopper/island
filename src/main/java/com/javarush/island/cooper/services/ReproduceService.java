package com.javarush.island.cooper.services;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import com.javarush.island.cooper.entity.*;
import com.javarush.island.cooper.system.Settings;
import com.javarush.island.cooper.interfaces.Hungrable;
import com.javarush.island.cooper.constants.AnimalConstants;

public class ReproduceService extends Service {
    public ReproduceService(Island island, int y, Settings settings) {
        super(island, y, settings);
    }

    @Override
    public void run() {
        Cell cell;

        for (int x = 0; x < cells[y].length; x++) {
            cell = cells[y][x];
            reproduceAnimals(cell, settings);
        }
    }

    /**
     * Размножает животных
     * @param cell - клетка
     */
    private void reproduceAnimals(Cell cell, Settings settings) {
        Map<String, List<Unit>> animalPairs = new HashMap<>();
        Map<String, Integer> childrenCount = new HashMap<>();
        List<Unit> childrenList = new ArrayList<>();

        for (Unit unit : cell.getUnitList()) { // бежим по списку животных, создаем пары и делаем им детей
            if (!(unit instanceof Plant) && !(unit instanceof Caterpillar) && (unit.getFood() <= 0 || unit.isDie())) continue;
            if (unit instanceof Plant) growPlant(unit);

            String unitName = unit.getClass().getSimpleName();
            childrenCount.putIfAbsent(unitName, 0);
            int maxUnit = AnimalConstants.ANIMAL_MAX_COUNT.get(unitName); // максимальное число данных животных в ячейке
            int currentCountUnit = cell.getCountUnit(unitName) + childrenCount.get(unitName); // текущее число данных животных в ячейке
            int children = Math.min(settings.getChildCount(), maxUnit - currentCountUnit); // 1 детеныш у пары
            if (children == 0) continue;
            animalPairs.computeIfAbsent(unitName, k -> new ArrayList<>());
            animalPairs.get(unitName).add(unit);

            if (animalPairs.get(unitName).size() == 2) { // если нашлась жаждущая пара
                childrenList.addAll(createNewUnits(unitName, children)); // делаем детей
                childrenCount.put(unitName, childrenCount.get(unitName) + children); // ведем подсчет детей, чтобы не превысить макс число
                wasteEnergyDuringClappingCheeks(animalPairs, unitName); // тратим энергию на по-шлепаться
                animalPairs.put(unitName, new ArrayList<>()); // обнуляем список размножающихся пар данного вида
            }
        }

        addChildrenToCell(cell, childrenList); // добавляем всех детей в общий список клетки
    }

    /**
     * Создает детишек
     * @param unitName - название вида животного
     * @param children - количество детей
     * @return
     */
    private List<Unit> createNewUnits(String unitName, int children) {
        List<Unit> childrenList = new ArrayList<>();
        for (int i = 0; i < children; i++) childrenList.add(Unit.create(unitName));
        return childrenList;
    }

    /**
     * Тратит энергию на шлепки щечками
     * @param animalPairs - список из пары животных для размножения
     * @param unitName -  - название вида животного
     */
    private void wasteEnergyDuringClappingCheeks(Map<String, List<Unit>> animalPairs, String unitName) {
        Unit parent1 = animalPairs.get(unitName).get(0);
        Unit parent2 = animalPairs.get(unitName).get(1);
        if (parent1 instanceof Hungrable) ((Hungrable) parent1).wasteEnergy(); // трата энергии на поиски еды
        if (parent2 instanceof Hungrable) ((Hungrable) parent2).wasteEnergy(); // трата энергии на поиски еды
    }

    /**
     * Добавляет сделанных детей в общий список животных на клетке
     * @param cell - клетка
     * @param childrenList - список детей
     */
    private void addChildrenToCell(Cell cell, List<Unit> childrenList) {
        for (Unit newUnit : childrenList) newUnit.reproduce(cell);
    }

    /**
     * Выращивает растения
     */
    private void growPlant(Unit unit) {
        String unitName = unit.getClass().getSimpleName();
        float maxWeight = AnimalConstants.ANIMAL_MAX_WEIGHT.get(unitName);

        unit.setDie(false);
        if (unit.getWeight() < maxWeight) { // растениям просто восстанавливаем вес
            unit.setWeight(maxWeight);
        }
    }
}
