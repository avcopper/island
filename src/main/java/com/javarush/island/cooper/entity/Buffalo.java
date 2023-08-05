package com.javarush.island.cooper.entity;

public class Buffalo extends Herbivore {
    @Override
    public String toString() {
        return "Buffalo{weight=" + getWeight() + "; food=" + getFood() + "; isDie=" + isDie() + "; isMoved=" + isMoved() + '}';
    }
}
