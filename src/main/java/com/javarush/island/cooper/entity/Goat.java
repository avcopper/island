package com.javarush.island.cooper.entity;

public class Goat extends Herbivore {
    @Override
    public String toString() {
        return "Goat{weight=" + getWeight() + "; food=" + getFood() + "; isDie=" + isDie() + "; isMoved=" + isMoved() + '}';
    }
}
