package com.javarush.island.cooper.entity;

public class Deer extends Herbivore {
    @Override
    public String toString() {
        return "Deer{weight=" + getWeight() + "; food=" + getFood() + "; isDie=" + isDie() + "; isMoved=" + isMoved() + '}';
    }
}
