package com.javarush.island.cooper.entity;

public class Rabbit extends Herbivore {
    @Override
    public String toString() {
        return "Rabbit{weight=" + getWeight() + "; food=" + getFood() + "; isDie=" + isDie() + "; isMoved=" + isMoved() + '}';
    }
}
