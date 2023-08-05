package com.javarush.island.cooper.entity;

public class Mouse extends Herbivore {
    @Override
    public String toString() {
        return "Mouse{weight=" + getWeight() + "; food=" + getFood() + "; isDie=" + isDie() + "; isMoved=" + isMoved() + '}';
    }
}
