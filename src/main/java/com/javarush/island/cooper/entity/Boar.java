package com.javarush.island.cooper.entity;

public class Boar extends Herbivore {
    @Override
    public String toString() {
        return "Boar{weight=" + getWeight() + "; food=" + getFood() + "; isDie=" + isDie() + "; isMoved=" + isMoved() + '}';
    }
}
