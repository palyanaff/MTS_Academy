package application;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import ru.mts.Main;
import ru.mts.animal.AbstractAnimal;
import ru.mts.animal.Cat;
import ru.mts.animal.Dog;
import ru.mts.animal.Wolf;
import ru.mts.factory.AnimalProperties;
import ru.mts.repository.AnimalRepository;
import ru.mts.repository.AnimalRepositoryImpl;
import ru.mts.service.CreateService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = Main.class)
@ActiveProfiles("test")
public class ApplicationTest {

    @Autowired
    private AnimalRepositoryImpl animalRepository;

    @Test
    public void testStartApp() {

    }

    @Test
    public void testFindDuplicates(){
        // Not crash the application
        Map<String, Integer> duplicates = animalRepository.findDuplicate();
    }

    @Test
    public void testFindOlderAnimals(){
        int year = 10;

        Map<AbstractAnimal, Integer> olderAnimals = animalRepository.findOlderAnimal(year);

        olderAnimals.forEach((animal, yearDif) -> {
            assertTrue(yearDif >= year);
        });
    }

    @Test
    public void testFindOlderAnimalsYoungerThenYear(){
        int year = 1000000;

        Cat cat = new Cat(
                "White", "Young", BigDecimal.ZERO,
                "Cat", LocalDate.now(), "Saint Petersburg"
        );
        Dog dog = new Dog(
                "Husky", "Old", BigDecimal.ZERO,
                "Dog", LocalDate.now().minusYears(2), "Moscow"
        );
        Wolf wolf = new Wolf(
                "Grey", "Young", BigDecimal.ZERO,
                "Wolf", LocalDate.now().minusDays(10), "Forest"
        );


        AnimalRepository animalRepository = new AnimalRepositoryImpl(new CreateService() {
            @Override
            public Map<String, List<AbstractAnimal>> createAnimals() {
                Map<String, List<AbstractAnimal>> map = new HashMap<>();
                List<AbstractAnimal> catList = new ArrayList<>();
                catList.add(cat);

                List<AbstractAnimal> dogList = new ArrayList<>();
                dogList.add(dog);

                List<AbstractAnimal> wolfList = new ArrayList<>();
                wolfList.add(wolf);

                map.put("CAT", catList);
                map.put("DOG", dogList);
                map.put("WOLF", wolfList);
                return map;
            }

            @Override
            public Map<String, List<AbstractAnimal>> createAnimals(int capacity) {
                return createAnimals();
            }
        });

        Map<AbstractAnimal, Integer> olderAnimals = animalRepository.findOlderAnimal(year);

        System.out.println(olderAnimals.toString());
        System.out.println(dog);

        assertEquals(1, olderAnimals.size());
        assertTrue(olderAnimals.containsKey(dog));

    }
}
