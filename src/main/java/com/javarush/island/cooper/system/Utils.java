package com.javarush.island.cooper.system;

public class Utils {
    /**
     * Генерирует случайное число от нуля
     * @param max - максимальное число не включительно
     * @return
     */
    public static int generateInt(int max) {
        return (int) (Math.random() * max);
    }
}
