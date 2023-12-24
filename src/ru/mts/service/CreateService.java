package ru.mts.service;

import ru.mts.animal.AbstractAnimal;

/**
 * Interface for creating classes with Factory pattern that extends {@link AbstractAnimal}
 *
 * @author palyanaff
 * @version 1.0
 */
public interface CreateService {
    /**
     * Amount of classes that extends {@link AbstractAnimal}
     */
    int CLASS_AMOUNT = 3;

    /**
     * Method for creating array of {@link AbstractAnimal}
     *
     * @param capacity amount of animals in array
     * @return array of {@link AbstractAnimal}
     */
    AbstractAnimal[] createAnimals(int capacity);

    /**
     * Method for creating array of {@link ru.mts.animal.Dog}
     *
     * @param capacity amount of dogs in array
     * @return array of {@link ru.mts.animal.Dog}
     */
    AbstractAnimal[] createDogs(int capacity);

    /**
     * Method for creating array of {@link ru.mts.animal.Cat}
     *
     * @param capacity amount of cats in array
     * @return array of {@link ru.mts.animal.Cat}
     */
    AbstractAnimal[] createCats(int capacity);

    /**
     * Method for creating array of {@link ru.mts.animal.Wolf}
     *
     * @param capacity amount of wolves in array
     * @return array of {@link ru.mts.animal.Wolf}
     */
    AbstractAnimal[] createWolves(int capacity);
}
