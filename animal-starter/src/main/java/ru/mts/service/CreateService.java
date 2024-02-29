package ru.mts.service;

import ru.mts.animal.AbstractAnimal;

import java.util.List;
import java.util.Map;

/**
 * Interface for creating classes with Factory pattern that extends {@link AbstractAnimal}
 *
 * @author palyanaff
 * @version 3.0
 */

public interface CreateService {

    /**
     * Method for creating array of {@link AbstractAnimal}
     *
     * @return map of {@link AbstractAnimal}
     */
    Map<String, List<AbstractAnimal>> createAnimals();


    /**
     * Method for creating array of {@link AbstractAnimal}
     *
     * @param capacity amount of animals in array
     * @return map of {@link AbstractAnimal}
     */
    Map<String, List<AbstractAnimal>> createAnimals(int capacity);
}
