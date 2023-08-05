package com.javarush.island.cooper.services;

import javax.swing.*;
import com.javarush.island.cooper.entity.Cell;
import com.javarush.island.cooper.entity.Island;
import com.javarush.island.cooper.system.Settings;

abstract public class Service implements Runnable {
    protected Island island;
    protected int y;
    protected Settings settings;
    protected Cell[][] cells;
    protected JTextArea[][] tiles;

    public Service(Island island, int y, Settings settings) {
        this.island = island;
        this.y = y;
        this.settings = settings;
        this.cells = island.getCells();
        this.tiles = island.getTiles();
    }
}
