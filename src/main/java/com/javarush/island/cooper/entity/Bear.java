package com.javarush.island.cooper.entity;

public class Bear extends Predator {
    @Override
    public String toString() {
        return "Bear{weight=" + getWeight() + "; food=" + getFood() + "; isDie=" + isDie() + "; isMoved=" + isMoved() + '}';
    }
}
