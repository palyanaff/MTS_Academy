package ru.mts.factory;

import ru.mts.animal.AbstractAnimal;
import ru.mts.animal.Dog;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Random;

public class DogFactory extends AnimalFactory {
    @Override
    protected AbstractAnimal createAnimal() {
        Random random = new Random();
        int i = random.nextInt(100);
        return new Dog("Husky", "Lucky " + i, new BigDecimal(10.2 + i * 12),
                "Dog", LocalDate.now().minusDays(i), "Moscow");
    }
}
