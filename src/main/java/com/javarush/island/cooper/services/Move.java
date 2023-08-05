package com.javarush.island.cooper.services;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import com.javarush.island.cooper.entity.Island;
import com.javarush.island.cooper.system.Settings;

public class Move extends Simulation {
    public Move(Island island, Settings settings) {
        super(island, settings);
    }

    /**
     * Запускаем перемещение. Перерисовываем карты
     */
    @Override
    public void run() {
        int rows = getIsland().getCells().length;
        //ExecutorService executorService = Executors.newFixedThreadPool(rows);

        for (int y = 0; y < rows; y++) {
            //executorService.execute(new MoveService(getIsland(), y, getSettings()));
            new MoveService(getIsland(), y, getSettings()).run();
        }

        //executorService.shutdown();
        new Show(getIsland(), getSettings()).run();
    }
}
