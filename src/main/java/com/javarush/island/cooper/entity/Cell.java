package com.javarush.island.cooper.entity;

import java.util.Map;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

import com.javarush.island.cooper.constants.AnimalConstants;

public class Cell {
    private Coordinates coordinates;
    private List<Unit> unitList = new ArrayList<>(); // список животных на клетке
    private Map<String, Integer> countAnimals = new HashMap<>(); // количество животных каждого вида на клетке
    {
        countAnimals.put("Bear", 0);
        countAnimals.put("Boa", 0);
        countAnimals.put("Boar", 0);
        countAnimals.put("Buffalo", 0);
        countAnimals.put("Caterpillar", 0);
        countAnimals.put("Deer", 0);
        countAnimals.put("Duck", 0);
        countAnimals.put("Eagle", 0);
        countAnimals.put("Fox", 0);
        countAnimals.put("Goat", 0);
        countAnimals.put("Horse", 0);
        countAnimals.put("Mouse", 0);
        countAnimals.put("Rabbit", 0);
        countAnimals.put("Sheep", 0);
        countAnimals.put("Wolf", 0);
        countAnimals.put("Plant", 0);
    }

    public Cell(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    /**
     * Проверяет можно ли добавить еще одно животное данного вида на клетку
     * @param unitName - название вида животного
     * @return
     */
    public boolean canPutUnit(String unitName) {
        return countAnimals.get(unitName) < AnimalConstants.ANIMAL_MAX_COUNT.get(unitName);
    }

    /**
     * Добавляет существо на клетку
     * @param unit - существо
     */
    public void addUnit(Unit unit) {
        String unitName = unit.getClass().getSimpleName();
        unitList.add(unit);
        countAnimals.put(unitName, countAnimals.get(unitName) + 1);
    }

    /**
     * Удаляет существо с клетки
     * @param unit - существо
     */
    public void removeUnit(Unit unit) {
        String unitName = unit.getClass().getSimpleName();
        //unitList.remove(unit);
        countAnimals.put(unitName, countAnimals.get(unitName) - 1);
    }

    public List<Unit> getUnitList() {
        return unitList;
    }

    public Map<String, Integer> getCountAnimals() {
        return countAnimals;
    }

    public Integer getCountUnit(String unit) {
        return countAnimals.get(unit);
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "coordinates=" + coordinates +
                ",\n unitList=" + unitList +
                ",\n сountAnimals=" + countAnimals +
                '}';
    }
}
