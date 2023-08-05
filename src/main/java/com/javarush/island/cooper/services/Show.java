package com.javarush.island.cooper.services;

import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;
import com.javarush.island.cooper.entity.Island;
import com.javarush.island.cooper.system.Settings;

public class Show extends Simulation {
    public Show(Island island, Settings settings) {
        super(island, settings);
    }

    /**
     * Прорисовывает актуальную карту
     */
    public void run() {
        int rows = getIsland().getCells().length;
        ExecutorService executorService = Executors.newFixedThreadPool(rows);

        for (int y = 0; y < rows; y++)
            executorService.execute(new ShowService(getIsland(), y, getSettings()));

        executorService.shutdown();
    }
}
