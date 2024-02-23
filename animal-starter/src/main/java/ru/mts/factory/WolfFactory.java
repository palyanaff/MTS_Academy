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
    private final AnimalProperties animalProperties;

    List<String> wolfNames;

    public WolfFactory(AnimalProperties animalProperties) {
        this.animalProperties = animalProperties;
    }

    @PostConstruct
    private void initFactoryNames() {
        wolfNames = animalProperties.getWolfNames();
    }

    @Override
    protected AbstractAnimal createAnimal() {
        Random random = new Random();
        int i = random.nextInt(100);
        Wolf wolf = new Wolf("Grey","Wolf" + i, new BigDecimal(25.25 + i * 20),
                "Wolf", LocalDate.now().minusMonths(i * 2), "Forest");
        if (wolfNames != null) {
            wolf = new Wolf("Grey", wolfNames.get(i % wolfNames.size()), new BigDecimal(25.25 + i * 20),
                    "Wolf", LocalDate.now().minusMonths(i * 2), "Forest");
        }
        return wolf;
    }
}
