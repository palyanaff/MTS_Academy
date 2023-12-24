package ru.mts.animal;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Wolf extends Predator {
    @Override
    public void bite() {
        super.bite();
    }

    public Wolf(String breed, String name, BigDecimal cost, String character, LocalDate birthDate, String location) {
        super(breed, name, cost, character, birthDate, location);
    }

    @Override
    public String toString() {
        return "Wolf{" +
                "breed='" + breed + '\'' +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", character='" + character + '\'' +
                ", birthDate=" + getFormattedDate(birthDate) +
                ", location='" + location + '\'' +
                '}';
    }
}
