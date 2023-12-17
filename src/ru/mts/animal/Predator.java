package ru.mts.animal;

import ru.mts.animal.AbstractAnimal;

import java.math.BigDecimal;

abstract public class Predator extends AbstractAnimal {
    protected String location;

    public Predator(String breed, String name, BigDecimal cost, String character, String location) {
        super(breed, name, cost, character);
        this.location = location;
    }

    public void bite() {
        System.out.printf("%s %s bite\n", breed, name);
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Predator{" +
                "breed='" + breed + '\'' +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", character='" + character + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
