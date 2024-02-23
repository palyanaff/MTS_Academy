package ru.mts.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.mts.animal.AbstractAnimal;
import ru.mts.animal.Dog;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

/**
 * Class that make random Dog
 *
 * @author palyanaff
 * @version 1.0
 */
@Component
public class DogFactory extends AnimalFactory {

    @Autowired
    private AnimalProperties animalProperties;

    @Override
    protected AbstractAnimal createAnimal() {
        Random random = new Random();
        List<String> dogNames = animalProperties.getDogNames();
        int i = random.nextInt(100);
        return new Dog("Husky", dogNames.get(i % dogNames.size()), new BigDecimal(10.2 + i * 12),
                "Dog", LocalDate.now().minusDays(i).minusYears(i), "Moscow");
    }
}
