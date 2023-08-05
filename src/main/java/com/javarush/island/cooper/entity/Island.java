package com.javarush.island.cooper.entity;

import javax.swing.*;
import com.javarush.island.cooper.system.Settings;

public class Island {
    private Cell[][] cells;
    private JTextArea[][] tiles;

    public Island(Settings settings) {
        cells = new Cell[settings.getRowsCount()][settings.getColsCount()];
        tiles = new JTextArea[settings.getRowsCount()][settings.getColsCount()];
    }

    public Cell[][] getCells() {
        return cells;
    }

    public JTextArea[][] getTiles() {
        return tiles;
    }
}
