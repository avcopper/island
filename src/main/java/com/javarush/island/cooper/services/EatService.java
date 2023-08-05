package com.javarush.island.cooper.services;

import java.util.List;

import com.javarush.island.cooper.entity.Caterpillar;
import com.javarush.island.cooper.entity.Unit;
import com.javarush.island.cooper.entity.Cell;
import com.javarush.island.cooper.entity.Island;
import com.javarush.island.cooper.system.Settings;
import com.javarush.island.cooper.interfaces.Eatable;
import com.javarush.island.cooper.interfaces.Hungrable;

public class EatService extends Service {
    public EatService(Island island, int y, Settings settings) {
        super(island, y, settings);
    }

    /**
     * Пытаемся покормить животных другими существами
     */
    @Override
    public void run() {
        Cell cell;

        for (int x = 0; x < cells[y].length; x++) {
            cell = cells[y][x];
            Unit unit;
            Unit unitForDiner;
            List<Unit> unitList = cell.getUnitList();

            for (int i = 0; i < unitList.size(); i++) {
                unit = unitList.get(i);

                if (!(unit instanceof Eatable) || unit instanceof Caterpillar || !unit.isHungry() || unit.isDie()) continue; // растения, червяки не жрут, сытые и мертвые тоже. червяк конечно спорно, но оставим на совести других и добавим как костыль...

                for (int j = 0; j < unitList.size(); j++) {
                    unitForDiner = unitList.get(j);

                    if (unit == unitForDiner) continue; // самого себя нельзя есть
                    if (unitForDiner.getWeight() <= 0) continue; // уже съеденного до костей есть нельзя
                    if (unit.canEat(unitForDiner) && unit.canCatch(unitForDiner)) ((Eatable) unit).eat(unitForDiner); // пожрал
                }

                if (unit instanceof Hungrable) ((Hungrable) unit).wasteEnergy(); // трата энергии на поиски еды
            }
        }
    }
}
