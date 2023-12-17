package ru.mts.service;

import ru.mts.animal.AbstractAnimal;
import ru.mts.animal.Cat;
import ru.mts.animal.Dog;
import ru.mts.animal.Wolf;

import java.math.BigDecimal;

public interface CreateAnimalService {
    final int CLASS_AMOUNT = 3;

    default AbstractAnimal setAnimal(int i) {
        AbstractAnimal animal;
        switch (i % CLASS_AMOUNT) {
            case 0:
                animal = new Dog("Husky", "Lucky " + i, new BigDecimal(10.2 + i * 12), "Dog", "Moscow");
                break;
            case 1:
                animal = new Wolf("Grey", "Wolf " + i, new BigDecimal(25.25 + i * 20), "Wolf", "Forest");
                break;
            case 2:
                animal = new Cat("White", "Barsik " + i, new BigDecimal(15.33 + i * 5), "Cat", "Saint Petersburg");
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + i % CLASS_AMOUNT);
        }
        return animal;
    }

    default void createAnimal() {
        int i = 0;
        while (i < 10) {
            System.out.println(setAnimal(i).toString());
            i++;
        }
    }
}
