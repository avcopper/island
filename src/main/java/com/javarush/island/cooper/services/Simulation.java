package com.javarush.island.cooper.services;

import com.javarush.island.cooper.entity.Island;
import com.javarush.island.cooper.system.Settings;

public abstract class Simulation implements Runnable {
    private Island island;
    private Settings settings;

    public Simulation(Island island, Settings settings) {
        this.island = island;
        this.settings = settings;
    }

    public Island getIsland() {
        return island;
    }

    public Settings getSettings() {
        return settings;
    }
}
