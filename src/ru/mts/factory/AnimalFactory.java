package ru.mts.factory;

import ru.mts.animal.AbstractAnimal;

public abstract class AnimalFactory {
    public AbstractAnimal create() {
        return createAnimal();
    }

    protected abstract AbstractAnimal createAnimal();
}
