package com.javarush.island.cooper.interfaces;

import com.javarush.island.cooper.entity.Cell;

import javax.swing.*;

public interface Moveable {
    void move(Cell cell, Cell newCell) throws CloneNotSupportedException;
}
