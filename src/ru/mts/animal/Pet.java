package ru.mts.animal;

import ru.mts.animal.AbstractAnimal;

import java.math.BigDecimal;

abstract public class Pet extends AbstractAnimal {
    protected String address;

    public Pet(String breed, String name, BigDecimal cost, String character, String address) {
        super(breed, name, cost, character);
        this.address = address;
    }

    abstract public void makeSound();

    public String getAddress() {
        return address;
    }

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
