package ru.mts.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.mts.animal.AbstractAnimal;

import java.util.Random;

@Component
public class RandomFactory {
    private final CatFactory catFactory;
    private final DogFactory dogFactory;
    private final WolfFactory wolfFactory;

    public RandomFactory(CatFactory catFactory, DogFactory dogFactory, WolfFactory wolfFactory) {
        this.catFactory = catFactory;
        this.dogFactory = dogFactory;
        this.wolfFactory = wolfFactory;
    }

    public AbstractAnimal createRandomAnimal() {
        int ind = new Random().nextInt(3);
        switch (ind) {
            case 0:
                return catFactory.createAnimal();
            case 1:
                return dogFactory.createAnimal();
            case 2:
                return wolfFactory.createAnimal();
        }
        throw new RuntimeException();
    }
}
