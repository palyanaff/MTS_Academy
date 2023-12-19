package ru.mts.animal;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Abstract class that contains main logic of animals
 *
 * @author palyanaff
 * @version 1.0
 */
abstract public class AbstractAnimal implements Animal {
    /**
     * Animal breed
     */
    protected String breed;
    /**
     * Animal name
     */
    protected String name;
    /**
     * Animal cost
     */
    protected BigDecimal cost;
    /**
     * Animal character
     */
    protected String character;

    /**
     * Constructor for abstract animal class
     *
     * @param breed     breed of predator as String
     * @param name      name of predator as String
     * @param cost      cost of predator as BigDecimal
     * @param character character of predator as String
     */
    public AbstractAnimal(String breed, String name, BigDecimal cost, String character) {
        this.breed = breed;
        this.name = name;
        this.cost = cost.setScale(2, RoundingMode.HALF_UP);
        this.character = character;
    }

    @Override
    public String getBreed() {
        return breed;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public BigDecimal getCost() {
        return cost;
    }

    @Override
    public String getCharacter() {
        return character;
    }

    @Override
    public String toString() {
        return "AbstractAnimal{" +
                "breed='" + breed + '\'' +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", character='" + character + '\'' +
                '}';
    }
}
