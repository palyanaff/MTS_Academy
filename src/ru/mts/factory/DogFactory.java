package ru.mts.factory;

import ru.mts.animal.AbstractAnimal;
import ru.mts.animal.Dog;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Random;

/**
 * Class that make random Dog
 *
 * @author palyanaff
 * @version 1.0
 */
public class DogFactory extends AnimalFactory {
    @Override
    protected AbstractAnimal createAnimal() {
        Random random = new Random();
        int i = random.nextInt(100);
        return new Dog("Husky", "Lucky " + i, new BigDecimal(10.2 + i * 12),
                "Dog", LocalDate.now().minusDays(i).minusYears(i), "Moscow");
    }
}
