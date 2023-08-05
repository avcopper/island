package com.javarush.island.cooper.entity;

import com.javarush.island.cooper.interfaces.Dieable;
import com.javarush.island.cooper.interfaces.Eatable;
import com.javarush.island.cooper.interfaces.Moveable;
import com.javarush.island.cooper.interfaces.Hungrable;
import com.javarush.island.cooper.constants.AnimalConstants;

abstract public class Animal extends Unit implements Eatable, Moveable, Hungrable, Dieable {
    /**
     * Едим
     * @param unitForDiner - пойманное животное
     */
    @Override
    public synchronized void eat(Unit unitForDiner) {
        String unitName = getClass().getSimpleName();
        float maxWeight = AnimalConstants.ANIMAL_MAX_WEIGHT.get(unitName);
        float canEat = AnimalConstants.ANIMAL_MAX_FOOD.get(unitName) - getFood();
        float willEat = Math.min(unitForDiner.getWeight(), canEat);

        setFood(getFood() + willEat); // едим
        if (getWeight() < maxWeight) { // если вес не максимальный, то толстеем
            float maxWeightChange = maxWeight * AnimalConstants.WEIGHT_CHANGE_COEFFICIENT;
            float currentWeightChange = Math.min(maxWeight - getWeight(), maxWeightChange);
            setWeight(getWeight() + currentWeightChange);
        }

        unitForDiner.setWeight(unitForDiner.getWeight() - willEat);
        unitForDiner.setDie(true); // если от тебя откусили кусок, то ты скорее всего труп
    }

    /**
     * Перемещаемся
     * @param cell - исходная клетка
     * @param newCell - новая клетка
     */
    @Override
    public synchronized void move(Cell cell, Cell newCell) {
        setMoved(true);
        Unit newUnit = clone();
        newCell.addUnit(newUnit);
        cell.removeUnit(this);
    }

    /**
     * Умираем
     * @param cell - клетка
     */
    @Override
    public synchronized void die(Cell cell) {
        cell.removeUnit(this); // растения не умирают после съедения
    }

    /**
     * Тратим энергию на какие-то действия
     * Сначала тратим уровень насыщения, потом живой вес животного
     */
    @Override
    public synchronized void wasteEnergy() {
        String unitName = getClass().getSimpleName();

        if (getFood() > 0) { // если уровень насыщения еще не потрачен, то сначала снижаем его
            float maxWastedEnergy = AnimalConstants.ANIMAL_MAX_FOOD.get(unitName) * AnimalConstants.FOOD_CHANGE_COEFFICIENT;
            float willWasteFood = Math.min(getFood(), maxWastedEnergy);
            setFood(getFood() - willWasteFood);
        } else { // у голодного начинаем снижать вес
            float maxWastedWeight = getWeight() * AnimalConstants.WEIGHT_CHANGE_COEFFICIENT;
            float willWasteWeight = Math.min(getWeight(), maxWastedWeight);
            setWeight(getWeight() - willWasteWeight);
        }
    }

    @Override
    public String toString() {
        return "Animal{weight=" + getWeight() + "; food=" + getFood() + "; isDie=" + isDie() + "; isMoved=" + isMoved() + '}';
    }
}
