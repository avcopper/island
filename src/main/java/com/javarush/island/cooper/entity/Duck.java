package com.javarush.island.cooper.entity;

public class Duck extends Herbivore {
    @Override
    public String toString() {
        return "Duck{weight=" + getWeight() + "; food=" + getFood() + "; isDie=" + isDie() + "; isMoved=" + isMoved() + '}';
    }
}
