package ru.mts;

import java.math.BigDecimal;

public class Wolf extends Predator {
    @Override
    public void bite() {
        super.bite();
    }

    public Wolf(String breed, String name, BigDecimal cost, String character, String location) {
        super(breed, name, cost, character, location);
    }

    @Override
    public String toString() {
        return "Wolf{" +
                "breed='" + breed + '\'' +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", character='" + character + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
