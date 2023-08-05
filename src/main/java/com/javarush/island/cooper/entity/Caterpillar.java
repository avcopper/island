package com.javarush.island.cooper.entity;

public class Caterpillar extends Herbivore {
    @Override
    public String toString() {
        return "Caterpillar{weight=" + getWeight() + "; food=" + getFood() + "; isDie=" + isDie() + "; isMoved=" + isMoved() + '}';
    }
}
