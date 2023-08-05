package com.javarush.island.cooper.entity;

public class Fox extends Predator {
    @Override
    public String toString() {
        return "Fox{weight=" + getWeight() + "; food=" + getFood() + "; isDie=" + isDie() + "; isMoved=" + isMoved() + '}';
    }
}
