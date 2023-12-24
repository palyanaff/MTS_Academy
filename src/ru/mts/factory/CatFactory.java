package ru.mts.factory;

import ru.mts.animal.AbstractAnimal;
import ru.mts.animal.Cat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Random;

public class CatFactory extends AnimalFactory {
    @Override
    protected AbstractAnimal createAnimal() {
        Random random = new Random();
        int i = random.nextInt(100);
        return new Cat("White", "Barsik " + i, new BigDecimal(15.33 + i * 5),
                "Cat", LocalDate.now().minusYears(i), "Saint Petersburg");
    }
}
