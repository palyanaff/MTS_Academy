package ru.mts.service;

import ru.mts.animal.AbstractAnimal;

public interface CreateService {
    AbstractAnimal[] createAnimals(int capacity);

    AbstractAnimal[] createDogs(int capacity);

    AbstractAnimal[] createCats(int capacity);

    AbstractAnimal[] createWolfs(int capacity);
}
