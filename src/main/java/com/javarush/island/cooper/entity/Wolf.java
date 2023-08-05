package com.javarush.island.cooper.entity;

public class Wolf extends Predator {
    @Override
    public String toString() {
        return "Wolf{weight=" + getWeight() + "; food=" + getFood() + "; isDie=" + isDie() + "; isMoved=" + isMoved() + '}';
    }
}
