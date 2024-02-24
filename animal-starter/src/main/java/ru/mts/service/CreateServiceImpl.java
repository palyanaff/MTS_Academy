package ru.mts.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import ru.mts.animal.*;
import ru.mts.factory.RandomFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Class for creating random animals with Factory pattern that extends {@link ru.mts.animal.AbstractAnimal}
 *
 * @author palyanaff
 * @version 3.0
 */
@Service
@Scope(value = "prototype")
public class CreateServiceImpl implements CreateService {
    private List<AnimalsEnum> animalType;

    private final RandomFactory randomFactory;

    public CreateServiceImpl(RandomFactory randomFactory) {
        this.randomFactory = randomFactory;
    }

    @Override
    public Map<String, List<AbstractAnimal>> createAnimals() {
        return createAnimals(10);
    }

    @Override
    public Map<String, List<AbstractAnimal>> createAnimals(int capacity) {
        Map<String, List<AbstractAnimal>> animals = new HashMap<>();
        for (int i = 0; i < capacity; i++) {
            AbstractAnimal animal = randomFactory.createRandomAnimal();
            if (animals.get(defineAnimalType(animal)) == null) {
                animals.put(defineAnimalType(animal), new ArrayList<>());
            }
            animals.get(defineAnimalType(animal)).add(animal);
        }
        return animals;
    }

    private String defineAnimalType(AbstractAnimal animal) {
        if (animal instanceof Cat)
            return AnimalsEnum.CAT.name();
        if (animal instanceof Dog)
            return AnimalsEnum.DOG.name();
        if (animal instanceof Wolf)
            return AnimalsEnum.WOLF.name();
        return "Undefined";
    }
}
