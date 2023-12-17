package ru.mts.animal;

import java.math.BigDecimal;

public class Dog extends Pet {
    public Dog(String breed, String name, BigDecimal cost, String character, String address) {
        super(breed, name, cost, character, address);
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
                ", address='" + address + '\'' +
                '}';
    }
}
