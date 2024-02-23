package ru.mts.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.mts.animal.AbstractAnimal;

import java.util.Random;

@Component
public class RandomFactory {
    @Autowired
    private CatFactory catFactory;
    @Autowired
    private DogFactory dogFactory;
    @Autowired
    private WolfFactory wolfFactory;

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
