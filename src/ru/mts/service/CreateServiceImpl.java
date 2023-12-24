package ru.mts.service;

import ru.mts.animal.AbstractAnimal;
import ru.mts.animal.Cat;
import ru.mts.animal.Dog;
import ru.mts.animal.Wolf;
import ru.mts.factory.CatFactory;
import ru.mts.factory.DogFactory;
import ru.mts.factory.WolfFactory;

public class CreateServiceImpl implements CreateService {
    @Override
    public AbstractAnimal[] createAnimals(int capacity) {
        int CLASS_AMOUNT = 3;
        AbstractAnimal[] animals = new AbstractAnimal[capacity];
        DogFactory df = new DogFactory();
        CatFactory cf = new CatFactory();
        WolfFactory wf = new WolfFactory();
        for (int i = 0; i < capacity; i++) {
            switch (i % CLASS_AMOUNT) {
                case 0:
                    animals[i] = df.create();
                    break;
                case 1:
                    animals[i] = wf.create();
                    break;
                case 2:
                    animals[i] = cf.create();
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + i % CLASS_AMOUNT);
            }
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
    public AbstractAnimal[] createWolfs(int capacity) {
        AbstractAnimal[] wolfs = new Wolf[capacity];
        WolfFactory wf = new WolfFactory();
        for (int i = 0; i < capacity; i++) {
            wolfs[i] = wf.create();
        }
        return wolfs;
    }
}
