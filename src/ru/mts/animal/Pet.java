package ru.mts.animal;

import java.math.BigDecimal;

/**
 * Abstract class that contains main logic of pe
 *
 * @author palyanaff
 * @version 1.0
 */
abstract public class Pet extends AbstractAnimal {
    /**
     * Pet address
     */
    protected String address;

    /**
     * Constructor for pet class
     *
     * @param breed     breed of predator as String
     * @param name      name of predator as String
     * @param cost      cost of predator as BigDecimal
     * @param character character of predator as String
     * @param address   location of predator as String
     */
    public Pet(String breed, String name, BigDecimal cost, String character, String address) {
        super(breed, name, cost, character);
        this.address = address;
    }

    /**
     * Abstract method for making sound of pet
     */
    abstract public void makeSound();

    /**
     * Getter for pet address
     *
     * @return address {@link Pet#address} as String
     */
    public String getAddress() {
        return address;
    }

    /**
     * Setter for pet address{@link Pet#address}
     *
     * @param address address of pet as String
     */
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "breed='" + breed + '\'' +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", character='" + character + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
