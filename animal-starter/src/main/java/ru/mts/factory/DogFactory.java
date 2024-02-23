package ru.mts.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.mts.animal.AbstractAnimal;
import ru.mts.animal.Dog;

import javax.annotation.PostConstruct;
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

    private final AnimalProperties animalProperties;

    private List<String> dogNames;

    public DogFactory(AnimalProperties animalProperties) {
        this.animalProperties = animalProperties;
    }

    @PostConstruct
    private void initFactoryNames() {
        dogNames = animalProperties.getDogNames();
    }

    @Override
    protected AbstractAnimal createAnimal() {
        Random random = new Random();
        int i = random.nextInt(100);
        Dog dog = new Dog("Husky", "Dog" + i, new BigDecimal(10.2 + i * 12),
                "Dog", LocalDate.now().minusDays(i).minusYears(i), "Moscow");
        if (dogNames != null) {
            dog = new Dog("Husky", dogNames.get(i % dogNames.size()), new BigDecimal(10.2 + i * 12),
                    "Dog", LocalDate.now().minusDays(i).minusYears(i), "Moscow");
        }
        return dog;
    }
}
