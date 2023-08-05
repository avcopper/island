package com.javarush.island.cooper.entity;

import javax.swing.*;
import java.util.Iterator;

public class Plant extends Unit {
    @Override
    public String toString() {
        return "Plant{weight=" + getWeight() + "; food=" + getFood() + "; isDie=" + isDie() + "; isMoved=" + isMoved() + '}';
    }
}
