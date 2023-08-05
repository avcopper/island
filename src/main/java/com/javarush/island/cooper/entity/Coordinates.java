package com.javarush.island.cooper.entity;

import java.util.Objects;
import com.javarush.island.cooper.system.Utils;

public class Coordinates {
    private int x;
    private int y;

    public Coordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Coordinates generateCoordinates(int maxX, int maxY) {
        return new Coordinates(Utils.generateInt(maxX), Utils.generateInt(maxY));
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Coordinates{x=" + x + ", y=" + y + '}';
    }
}
