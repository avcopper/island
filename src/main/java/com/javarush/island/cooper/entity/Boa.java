package com.javarush.island.cooper.entity;

public class Boa extends Predator {
    @Override
    public String toString() {
        return "Boa{weight=" + getWeight() + "; food=" + getFood() + "; isDie=" + isDie() + "; isMoved=" + isMoved() + '}';
    }
}
