package com.javarush.island.cooper.system;

import java.util.Map;
import java.nio.file.Path;
import java.io.IOException;
import java.nio.file.Files;
import com.google.gson.Gson;
import java.io.Serializable;
import com.javarush.island.cooper.constants.AppConstants;
import com.javarush.island.cooper.exception.AppException;

public class Settings implements Serializable {
    private static Settings instance;
    private int windowWidth;                       // ширина окна
    private int windowHeight;                      // высота окна
    private int rowsCount;                         // количество рядов - координата y
    private int colsCount;                         // количество столбцов - координата x
    private int terminationCondition;              // условие остановки симуляции
    private int maxCycles;                         // максимальное число циклов симуляции
    private int childCount;                        // число детей у одной пары
    private Map<String, Integer> animalStartCount; // стартовое количество животных на острове

    private Settings() {
    }

    public static Settings getInstance() throws IOException {
        if (instance == null) {
            Path settingsFile = Path.of(AppConstants.SETTINGS_FILE);

            if (Files.isRegularFile(settingsFile))
                instance = new Gson().fromJson(Files.readString(settingsFile), Settings.class);
            else
                throw new AppException(AppConstants.NOT_FOUND_SETTINGS_FILE);
        }

        return instance;
    }

    public int getWindowWidth() {
        return windowWidth;
    }

    public int getWindowHeight() {
        return windowHeight;
    }

    public int getRowsCount() {
        return rowsCount;
    }

    public int getColsCount() {
        return colsCount;
    }

    public int getTerminationCondition() {
        return terminationCondition;
    }

    public int getMaxCycles() {
        return maxCycles;
    }

    public int getChildCount() {
        return childCount;
    }

    public Map<String, Integer> getAnimalStartCount() {
        return animalStartCount;
    }

    @Override
    public String toString() {
        return "Settings{" +
                "windowWidth=" + windowWidth +
                ", windowHeight=" + windowHeight +
                ", rowsCount=" + rowsCount +
                ", colsCount=" + colsCount +
                ", maxCycles=" + maxCycles +
                ", childCount=" + childCount +
                ", \nanimalStartCount=" + animalStartCount +
                '}';
    }
}
