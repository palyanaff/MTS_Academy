package ru.mts.service;

import ru.mts.animal.AbstractAnimal;
import ru.mts.animal.Cat;
import ru.mts.animal.Dog;
import ru.mts.animal.Wolf;
import ru.mts.factory.CatFactory;
import ru.mts.factory.DogFactory;
import ru.mts.factory.RandomFactory;
import ru.mts.factory.WolfFactory;

/**
 * Class for creating random animals with Factory pattern that extends {@link ru.mts.animal.AbstractAnimal}
 *
 * @author palyanaff
 * @version 1.0
 */
public class CreateServiceImpl implements CreateService {
    @Override
    public AbstractAnimal[] createAnimals(int capacity) {
        AbstractAnimal[] animals = new AbstractAnimal[capacity];
        for (int i = 0; i < capacity; i++) {
            animals[i] = RandomFactory.factory.createRandomAnimal();
        }
        return animals;
    }

    @Override
    public AbstractAnimal[] createDogs(int capacity) {
        AbstractAnimal[] dogs = new Dog[capacity];
        DogFactory df = new DogFactory();
        for (int i = 0; i < capacity; i++) {
            dogs[i] = df.create();
        }
        return dogs;
    }

    @Override
    public AbstractAnimal[] createCats(int capacity) {
        AbstractAnimal[] cats = new Cat[capacity];
        CatFactory cf = new CatFactory();
        for (int i = 0; i < capacity; i++) {
            cats[i] = cf.create();
        }
        return cats;
    }

    @Override
    public AbstractAnimal[] createWolves(int capacity) {
        AbstractAnimal[] wolfs = new Wolf[capacity];
        WolfFactory wf = new WolfFactory();
        for (int i = 0; i < capacity; i++) {
            wolfs[i] = wf.create();
        }
        return wolfs;
    }
}
