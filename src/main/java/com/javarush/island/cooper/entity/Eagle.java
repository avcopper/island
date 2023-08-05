package com.javarush.island.cooper.entity;

public class Eagle extends Predator {
    @Override
    public String toString() {
        return "Eagle{weight=" + getWeight() + "; food=" + getFood() + "; isDie=" + isDie() + "; isMoved=" + isMoved() + '}';
    }
}
