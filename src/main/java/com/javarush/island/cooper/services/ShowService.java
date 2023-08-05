package com.javarush.island.cooper.services;

import javax.swing.*;
import java.util.Map;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;
import com.javarush.island.cooper.entity.Cell;
import com.javarush.island.cooper.entity.Island;
import com.javarush.island.cooper.system.Settings;
import com.javarush.island.cooper.constants.AnimalConstants;

public class ShowService extends Service {
    public ShowService(Island island, int y, Settings settings) {
        super(island, y, settings);
    }

    /**
     * Размещает животных в клетках
     */
    @Override
    public void run() {
        Cell[][] cells = island.getCells();
        JTextArea[][] tiles = island.getTiles();
        StringBuilder result;
        Map<String, Integer> countAnimals;

        for (int x = 0; x < cells[y].length; x++) {
            result = new StringBuilder();
            countAnimals = cells[y][x].getCountAnimals().entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));

            for (Map.Entry<String, Integer> unit : countAnimals.entrySet()) {
                if (unit.getValue() > 0) {
                    String icon = AnimalConstants.ANIMAL_ICON.get(unit.getKey());
                    result.append("[").append(icon).append("*").append(unit.getValue()).append("]");
                }
            }

            tiles[y][x].setText(result.toString());
        }
    }
}
