package ru.mts;

import java.math.BigDecimal;

public class Cat extends Pet {
    public Cat(String breed, String name, BigDecimal cost, String character, String address) {
        super(breed, name, cost, character, address);
    }

    @Override
    public void makeSound() {
        System.out.println("Meow");
    }

    @Override
    public String toString() {
        return "Cat{" +
                "breed='" + breed + '\'' +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", character='" + character + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
