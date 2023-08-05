package com.javarush.island.cooper.services;

import java.util.List;
import java.util.Iterator;
import com.javarush.island.cooper.entity.Unit;
import com.javarush.island.cooper.entity.Cell;
import com.javarush.island.cooper.entity.Island;
import com.javarush.island.cooper.system.Settings;
import com.javarush.island.cooper.interfaces.Dieable;

public class DieService extends Service {
    public DieService(Island island, int y, Settings settings) {
        super(island, y, settings);
    }

    /**
     * Убираем всех умерших с острова
     */
    @Override
    public void run() {
        Cell cell;
        List<Unit> unitList;

        for (int x = 0; x < cells[y].length; x++) {
            cell = cells[y][x];
            unitList = cell.getUnitList();
            Unit unit;

            Iterator<Unit> iterator = unitList.iterator();
            while (iterator.hasNext()) {
                unit = iterator.next();
                unit.setMoved(false);
                if (unit instanceof Dieable && unit.isDie()) {
                    ((Dieable)unit).die(cell);
                    iterator.remove();
                }
            }
        }
    }
}
