package ru.mts.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.mts.animal.AbstractAnimal;
import ru.mts.animal.Cat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

/**
 * Class that make random Cat
 *
 * @author palyanaff
 * @version 1.0
 */
@Component
public class CatFactory extends AnimalFactory {

    @Autowired
    private AnimalProperties animalProperties;


    @Override
    protected AbstractAnimal createAnimal() {
        Random random = new Random();

        List<String> catNames = animalProperties.getCatNames();
        int i = random.nextInt(100);

        return new Cat("White", catNames.get(i % catNames.size()), new BigDecimal(15.33 + i * 5),
                "Cat", LocalDate.now().minusYears(i).minusMonths(i), "Saint Petersburg");
    }
}
