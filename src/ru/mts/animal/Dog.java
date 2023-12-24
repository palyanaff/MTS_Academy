package ru.mts.animal;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Dog extends Pet {
    public Dog(String breed, String name, BigDecimal cost, String character, LocalDate birthDate, String address) {
        super(breed, name, cost, character, birthDate, address);
    }

    @Override
    public void makeSound() {
        System.out.println("Bark");
    }

    @Override
    public String toString() {
        return "Dog{" +
                "breed='" + breed + '\'' +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", character='" + character + '\'' +
                ", birthDate=" + getFormattedDate(birthDate) +
                ", address='" + address + '\'' +
                '}';
    }
}
