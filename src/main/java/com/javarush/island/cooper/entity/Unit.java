package com.javarush.island.cooper.entity;

import java.lang.reflect.Constructor;
import com.javarush.island.cooper.system.Utils;
import java.lang.reflect.InvocationTargetException;
import com.javarush.island.cooper.interfaces.Eatable;
import com.javarush.island.cooper.interfaces.Dieable;
import com.javarush.island.cooper.interfaces.Moveable;
import com.javarush.island.cooper.exception.AppException;
import com.javarush.island.cooper.interfaces.Reprodusable;
import com.javarush.island.cooper.constants.AnimalConstants;

abstract public class Unit implements Reprodusable, Cloneable {
    private float weight; // вес
    private float food; // уровень насыщения
    private boolean isDie = false;
    private boolean isMoved = false;

    public Unit() {
        String unitName = getClass().getSimpleName();
        this.weight = AnimalConstants.ANIMAL_MAX_WEIGHT.get(unitName);
        this.food = AnimalConstants.ANIMAL_MAX_FOOD.get(unitName) * AnimalConstants.FOOD_START_COEFFICIENT;
    }

    public Unit(float weight, float food) {
        this.weight = weight;
        this.food = food;
    }

    /**
     * Создание нового юнита
     * @param unitName - имя класса юнита
     * @return
     */
    public static Unit create(String unitName) {
        try {
            Class<?> unitClass = Class.forName("com.javarush.island.cooper.entity." + unitName);
            Constructor<?> constructor = unitClass.getConstructor();
            return  (Unit) constructor.newInstance();
        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | InstantiationException |
                 IllegalAccessException e) {
            throw new AppException(e);
        }
    }

    /**
     * Может ли одно животное сожрать другое
     * @param unitForDiner - пожираемый юнит
     * @return
     */
    public boolean canEat(Unit unitForDiner) {
        String unitName = getClass().getSimpleName();
        String unitNameForDiner = unitForDiner.getClass().getSimpleName();
        int canEatPercent = AnimalConstants.CAN_EAT.get(unitName).get(unitNameForDiner);
        float maxFood = AnimalConstants.ANIMAL_MAX_FOOD.get(unitName);
        return this instanceof Eatable && food < maxFood && canEatPercent > 0;
    }

    /**
     * Может ли одно животное поймать другое для съедения
     * @param unitForDiner - пожираемый юнит
     * @return
     */
    public boolean canCatch(Unit unitForDiner) {
        if (unitForDiner.isDie) return true;

        String unitName = getClass().getSimpleName();
        String unitNameForDiner = unitForDiner.getClass().getSimpleName();
        int canEatPercent = AnimalConstants.CAN_EAT.get(unitName).get(unitNameForDiner);
        int rnd = Utils.generateInt(101);
        return canEatPercent >= rnd;
    }

    /**
     * Сытый или нет
     * @return
     */
    public boolean isHungry() {
        return AnimalConstants.ANIMAL_MAX_FOOD.get(getClass().getSimpleName()) > food;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getFood() {
        return food;
    }

    public void setFood(float food) {
        this.food = food;
    }

    public boolean isDie() {
        if (isDie) return true;

        String unitName = getClass().getSimpleName();
        float criticalWeight = AnimalConstants.ANIMAL_MAX_WEIGHT.get(unitName) * AnimalConstants.WEIGHT_MIN_COEFFICIENT;
        if (getWeight() < criticalWeight) {
            setDie(true);
            return true;
        }
        return false;
    }

    public void setDie(boolean die) {
        isDie = die;
    }

    public boolean isMoved() {
        return isMoved;
    }

    public void setMoved(boolean moved) {
        isMoved = moved;
    }

    @Override
    public void reproduce(Cell cell) {
        cell.addUnit(this);
    }

    @Override
    public Unit clone() {
        String unitName = this.getClass().getSimpleName();
        Unit newUnit = create(unitName);
        newUnit.setWeight(getWeight());
        newUnit.setFood(getFood());
        newUnit.setDie(newUnit instanceof Dieable && isDie());
        newUnit.setMoved(newUnit instanceof Moveable && isMoved());
        return  newUnit;
    }

    @Override
    public String toString() {
        return "Unit{weight=" + weight + "; food=" + food + "; isDie=" + isDie + "; isMoved=" + isMoved() + '}';
    }
}
