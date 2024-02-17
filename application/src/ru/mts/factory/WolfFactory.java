package ru.mts.factory;

import ru.mts.animal.AbstractAnimal;
import ru.mts.animal.Wolf;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Random;

/**
 * Class that make random Wolf
 *
 * @author palyanaff
 * @version 1.0
 */
public class WolfFactory extends AnimalFactory {
    @Override
    protected AbstractAnimal createAnimal() {
        Random random = new Random();
        int i = random.nextInt(100);
        return new Wolf("Grey", "Wolf " + i, new BigDecimal(25.25 + i * 20),
                "Wolf", LocalDate.now().minusMonths(i * 2), "Forest");
    }
}
