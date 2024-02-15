package ru.mts.factory;

import ru.mts.animal.AbstractAnimal;

/**
 * Abstract class that contains main logic of Animal Factory
 *
 * @author palyanaff
 * @version 1.0
 */
public abstract class AnimalFactory {
    /**
     * Method for creating Animals in Factory pattern
     *
     * @return new animal as AbstractAnimal
     */
    public AbstractAnimal create() {
        return createAnimal();
    }

    protected abstract AbstractAnimal createAnimal();
}
