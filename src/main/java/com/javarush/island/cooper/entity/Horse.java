package com.javarush.island.cooper.entity;

public class Horse extends Herbivore {
    @Override
    public String toString() {
        return "Horse{weight=" + getWeight() + "; food=" + getFood() + "; isDie=" + isDie() + "; isMoved=" + isMoved() + '}';
    }
}
