package com.javarush.island.cooper.entity;

public class Sheep extends Herbivore {
    @Override
    public String toString() {
        return "Sheep{weight=" + getWeight() + "; food=" + getFood() + "; isDie=" + isDie() + "; isMoved=" + isMoved() + '}';
    }
}
