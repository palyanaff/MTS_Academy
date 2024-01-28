package ru.mts.service;

import ru.mts.animal.AbstractAnimal;
import ru.mts.animal.Cat;
import ru.mts.animal.Dog;
import ru.mts.animal.Wolf;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Interface for creating classes that extends {@link AbstractAnimal}
 *
 * @author palyanaff
 * @version 1.0
 */
public interface CreateAnimalService {
    /**
     * Amount of classes that extends {@link AbstractAnimal}
     */
    int CLASS_AMOUNT = 3;

    /**
     * Default method for creating unique animals
     *
     * @param i seed for determining which class to create
     * @return unique animal as {@link AbstractAnimal}
     */
    default AbstractAnimal setAnimal(int i) {
        AbstractAnimal animal;
        switch (i % CLASS_AMOUNT) {
            case 0:
                animal = new Dog("Husky", "Lucky " + i, new BigDecimal(10.2 + i * 12), "Dog", LocalDate.now().minusDays(i), "Moscow");
                break;
            case 1:
                animal = new Wolf("Grey", "Wolf " + i, new BigDecimal(25.25 + i * 20), "Wolf", LocalDate.now().minusMonths(i), "Forest");
                break;
            case 2:
                animal = new Cat("White", "Barsik " + i, new BigDecimal(15.33 + i * 5), "Cat", LocalDate.now().minusYears(i), "Saint Petersburg");
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + i % CLASS_AMOUNT);
        }
        return animal;
    }

    /**
     * Default method for creating 10 unique animals
     */
    default void createAnimal() {
        int i = 0;
        while (i < 10) {
            System.out.println(setAnimal(i).toString());
            i++;
        }
    }
}
