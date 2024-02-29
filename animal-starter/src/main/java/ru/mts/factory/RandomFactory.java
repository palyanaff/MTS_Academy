package ru.mts.factory;

import org.springframework.stereotype.Component;
import ru.mts.animal.AbstractAnimal;
import ru.mts.animal.AnimalsEnum;

import java.util.HashMap;
import java.util.Map;
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

    public Map<String, AbstractAnimal> createRandomAnimalWithType() {
        int ind = new Random().nextInt(3);
        Map<String, AbstractAnimal> map = new HashMap<>();
        switch (ind) {
            case 0:
                map.put(AnimalsEnum.CAT.name(), catFactory.createAnimal());
                return map;
            case 1:
                map.put(AnimalsEnum.DOG.name(), dogFactory.createAnimal());
                return map;
            case 2:
                map.put(AnimalsEnum.WOLF.name(), wolfFactory.createAnimal());
                return map;
        }
        throw new RuntimeException();
    }
}
