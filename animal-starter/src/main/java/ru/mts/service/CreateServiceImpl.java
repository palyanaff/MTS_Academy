package ru.mts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import ru.mts.animal.*;
import ru.mts.factory.CatFactory;
import ru.mts.factory.DogFactory;
import ru.mts.factory.RandomFactory;
import ru.mts.factory.WolfFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for creating random animals with Factory pattern that extends {@link ru.mts.animal.AbstractAnimal}
 *
 * @author palyanaff
 * @version 2.0
 */
@Service
@Scope(value = "prototype")
public class CreateServiceImpl implements CreateService {
    private List<AnimalsEnum> animalType;

    @Autowired
    private RandomFactory randomFactory;

    @Override
    public AbstractAnimal[] createAnimals() {
        return createAnimals(10);
    }

    @Override
    public AbstractAnimal[] createAnimals(int capacity) {
        AbstractAnimal[] animals = new AbstractAnimal[capacity];
        for (int i = 0; i < capacity; i++) {
            animals[i] = randomFactory.createRandomAnimal();
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

    public List<AnimalsEnum> defineAnimalType() {
        AbstractAnimal[] animals = createAnimals();
        List<AnimalsEnum> types = new ArrayList<>(animals.length);

        for (AbstractAnimal animal : animals) {
            if (animal instanceof Cat) {
                types.add(AnimalsEnum.CAT);
            } else if (animal instanceof Dog) {
                types.add(AnimalsEnum.DOG);
            } else if (animal instanceof Wolf) {
                types.add(AnimalsEnum.WOLF);
            }
        }
        return types;
    }

    public List<AnimalsEnum> getAnimalType() {
        return animalType;
    }

    public void setAnimalType(List<AnimalsEnum> animalType) {
        this.animalType = animalType;
    }
}
