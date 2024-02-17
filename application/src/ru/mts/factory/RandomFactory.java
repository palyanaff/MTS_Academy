package ru.mts.factory;

import ru.mts.animal.AbstractAnimal;

import java.util.Random;

public class RandomFactory {
    private final AnimalFactory[] factories;

    public static final RandomFactory factory = new RandomFactory(new AnimalFactory[]{
            new CatFactory(),
            new DogFactory(),
            new WolfFactory()
    });

    public RandomFactory(AnimalFactory[] factories) {
        this.factories = factories;
    }

    public AbstractAnimal createRandomAnimal() {
        int ind = new Random().nextInt(getFactories().length);
        return getFactories()[ind].create();
    }

    public AnimalFactory[] getFactories() {
        return factories;
    }
}
