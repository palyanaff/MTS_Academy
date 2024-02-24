package ru.mts.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.mts.animal.AbstractAnimal;
import ru.mts.animal.Wolf;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Random;

/**
 * Class that make random Wolf
 *
 * @author palyanaff
 * @version 1.0
 */
@Component
public class WolfFactory extends AnimalFactory {
    private final List<String> wolfNames;

    public WolfFactory(AnimalProperties animalProperties) {
        wolfNames = animalProperties.getWolfNames();
    }


    @Override
    public AbstractAnimal createAnimal() {
        Random random = new Random();
        int i = random.nextInt(100);

        return new Wolf("Grey", wolfNames.get(i % wolfNames.size()), new BigDecimal(25.25 + i * 20),
                "Wolf", LocalDate.now().minusMonths(i * 2), "Forest");
    }
}
