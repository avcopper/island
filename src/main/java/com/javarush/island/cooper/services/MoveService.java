package com.javarush.island.cooper.services;

import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;
import com.javarush.island.cooper.entity.Cell;
import com.javarush.island.cooper.entity.Unit;
import com.javarush.island.cooper.system.Utils;
import com.javarush.island.cooper.entity.Island;
import com.javarush.island.cooper.system.Settings;
import com.javarush.island.cooper.entity.Coordinates;
import com.javarush.island.cooper.interfaces.Moveable;
import com.javarush.island.cooper.interfaces.Hungrable;
import com.javarush.island.cooper.exception.AppException;
import com.javarush.island.cooper.constants.AnimalConstants;

public class MoveService extends Service {
    public MoveService(Island island, int y, Settings settings) {
        super(island, y, settings);
    }

    @Override
    public void run() {
        Cell cell;

        for (int x = 0; x < cells[y].length; x++) {
            cell = cells[y][x];
            Unit unit;
            String unitName;

            Iterator<Unit> iterator = cell.getUnitList().iterator();
            while (iterator.hasNext()) {
                unit = iterator.next();
                if (!(unit instanceof Moveable) || unit.isMoved()) continue; // без ножек или уже перемещен

                unitName = unit.getClass().getSimpleName();
                int maxSteps = AnimalConstants.ANIMAL_MAX_STEPS.get(unitName);
                int needSteps = Utils.generateInt(maxSteps + 1);

                if (needSteps > 0) moveUnit(unit, needSteps, cell, iterator);
            }
        }
    }

    /**
     * Двигаем животное на новую клетку
     * @param unit - животное
     * @param needSteps - необходимое количество шагов
     * @param cell - клетка
     */
    private void moveUnit(Unit unit, int needSteps, Cell cell, Iterator<Unit> iterator) {
        try {
            List<Cell> availableCellList;
            Cell newCell = cell;
            Coordinates cellCoordinates = newCell.getCoordinates();
            String unitName = unit.getClass().getSimpleName();

            for (int j = 0; j < needSteps; j++) {
                availableCellList = getAvailableCellList(unitName, cellCoordinates); // список доступных для перемещения клеток
                if (availableCellList.size() == 0) break; // если некуда идти, то и шевелиться не стоит
                newCell = availableCellList.get(Utils.generateInt(availableCellList.size())); // выбор клетки из доступных
            }

            if (unit instanceof Hungrable) ((Hungrable) unit).wasteEnergy(); // трата энергии на беготню

            if (newCell != cell) { // если не остался на исходной клетке, то шагаем
                ((Moveable) unit).move(cell, newCell);
                iterator.remove();
            }
        } catch (CloneNotSupportedException e) {
            throw new AppException(e);
        }
    }

    /**
     * Возвращает список доступных для перемещения соседних клеток. Берет только 4 соседние без диагональных.
     * Проверяет количество животных данного вида на клетках и сравнивает его с максимально доступным.
     * @param unitName - название животного
     * @param cellCoordinates - координаты ячейки
     * @return
     */
    private List<Cell> getAvailableCellList(String unitName, Coordinates cellCoordinates) {
        List<Cell> availableCellList = new ArrayList<>();
        int maxCount = AnimalConstants.ANIMAL_MAX_COUNT.get(unitName);

        if (cellCoordinates.getX() > 0 && cells[cellCoordinates.getY()][cellCoordinates.getX() - 1].getCountUnit(unitName) < maxCount)
            availableCellList.add(cells[cellCoordinates.getY()][cellCoordinates.getX() - 1]);

        if (cellCoordinates.getY() > 0 && cells[cellCoordinates.getY() - 1][cellCoordinates.getX()].getCountUnit(unitName) < maxCount)
            availableCellList.add(cells[cellCoordinates.getY() - 1][cellCoordinates.getX()]);

        if (cellCoordinates.getX() < settings.getColsCount() - 1 && cells[cellCoordinates.getY()][cellCoordinates.getX() + 1].getCountUnit(unitName) < maxCount)
            availableCellList.add(cells[cellCoordinates.getY()][cellCoordinates.getX() + 1]);

        if (cellCoordinates.getY() < settings.getRowsCount() - 1 && cells[cellCoordinates.getY() + 1][cellCoordinates.getX()].getCountUnit(unitName) < maxCount)
            availableCellList.add(cells[cellCoordinates.getY() + 1][cellCoordinates.getX()]);

        return availableCellList;
    }
}
