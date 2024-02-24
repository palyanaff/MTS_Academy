package Part2;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.mts.animal.AbstractAnimal;
import ru.mts.animal.Cat;
import ru.mts.animal.Dog;
import ru.mts.animal.Wolf;
import ru.mts.service.SearchServiceImpl;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class SearchServiceTests {

    private static SearchServiceImpl searchService;

    @BeforeAll
    public static void beforeAll() {
        searchService = new SearchServiceImpl();
    }


    @Test
    @DisplayName("Find leap year names test")
    public void testFindLeapYearNames() {
        int i = 0;
        AbstractAnimal cat1 = new Cat("White", "Barsik " + i++, new BigDecimal("0"),
                "Cat", LocalDate.of(2000, 1, 1), "Saint Petersburg");
        AbstractAnimal dog1 = new Dog("Husky", "Lucky " + i++, BigDecimal.ZERO,
                "Dog", LocalDate.of(2001, 1, 1), "Moscow");
        AbstractAnimal wolf1 = new Wolf("Grey", "Wolf " + i++, BigDecimal.ZERO,
                "Wolf", LocalDate.of(2002, 1, 1), "Forest");
        AbstractAnimal cat2 = new Cat("White", "Barsik " + i++, new BigDecimal("0"),
                "Cat", LocalDate.of(2003, 1, 1), "Saint Petersburg");
        AbstractAnimal dog2 = new Dog("Husky", "Lucky " + i++, BigDecimal.ZERO,
                "Dog", LocalDate.of(2004, 1, 1), "Moscow");
        AbstractAnimal wolf2 = new Wolf("Grey", "Wolf " + i++, BigDecimal.ZERO,
                "Wolf", LocalDate.of(2005, 1, 1), "Forest");


        AbstractAnimal[] animals = new AbstractAnimal[]{cat1, cat2, dog1, dog2, wolf1, wolf2};

        String[] result = searchService.findLeapYearNames(animals);
        assertArrayEquals(result, new String[]{cat1.getName(), dog2.getName()});
    }

    @Test
    @DisplayName("Find leap year names test")
    public void testFindOlderAnimal() {
        int i = 0;
        AbstractAnimal cat1 = new Cat("White", "Barsik " + i++, BigDecimal.ZERO,
                "Cat", LocalDate.of(2000, 1, 1), "Saint Petersburg");
        AbstractAnimal dog1 = new Dog("Husky", "Lucky " + i++, BigDecimal.ZERO,
                "Dog", LocalDate.of(2001, 1, 1), "Moscow");
        AbstractAnimal wolf1 = new Wolf("Grey", "Wolf " + i++, BigDecimal.ZERO,
                "Wolf", LocalDate.of(2002, 1, 1), "Forest");
        AbstractAnimal cat2 = new Cat("White", "Barsik " + i++, new BigDecimal("0"),
                "Cat", LocalDate.of(2003, 5, 2), "Saint Petersburg");
        AbstractAnimal dog2 = new Dog("Husky", "Lucky " + i++, BigDecimal.ZERO,
                "Dog", LocalDate.of(2004, 1, 1), "Moscow");
        AbstractAnimal wolf2 = new Wolf("Grey", "Wolf " + i++, BigDecimal.ZERO,
                "Wolf", LocalDate.of(2004, 1, 20), "Forest");
        AbstractAnimal wolf3 = new Wolf("Grey", "Wolf " + i++, BigDecimal.ZERO,
                "Wolf", LocalDate.of(2004, 3, 1), "Forest");
        AbstractAnimal wolf4 = new Wolf("Grey", "Wolf " + i++, BigDecimal.ZERO,
                "Wolf", LocalDate.now(), "Forest");

        AbstractAnimal[] animals = new AbstractAnimal[]{cat1, cat2, dog1, dog2, wolf1, wolf2, wolf3, wolf4};

        AbstractAnimal[] result = searchService.findOlderAnimal(animals, 20);
        assertArrayEquals(result, new AbstractAnimal[]{cat1, cat2, dog1, dog2, wolf1, wolf2});

        result = searchService.findOlderAnimal(animals, 22);
        assertArrayEquals(result, new AbstractAnimal[]{cat1, dog1, wolf1});
    }

    @Test
    @DisplayName("Find duplicates test")
    public void testFindDuplicate() {
        AbstractAnimal animal1 = new Cat("White", "Barsik", BigDecimal.ZERO,
                "Cat", LocalDate.of(2000, 1, 1), "Saint Petersburg");
        AbstractAnimal animal2 = new Dog("Husky", "Lucky", BigDecimal.ZERO,
                "Dog", LocalDate.of(2001, 1, 1), "Moscow");
        AbstractAnimal animal3 = new Wolf("Grey", "Wolf", BigDecimal.ZERO,
                "Wolf", LocalDate.of(2002, 1, 1), "Forest");
        AbstractAnimal animal4 = new Wolf("Grey", "Wolf", BigDecimal.ZERO,
                "Wolf", LocalDate.of(2002, 1, 1), "Forest");
        AbstractAnimal animal5 = new Wolf("Grey1", "Wolf", BigDecimal.ZERO,
                "Wolf", LocalDate.of(2002, 1, 1), "Forest");

        AbstractAnimal[] animals = new AbstractAnimal[]{animal1, animal1, animal2, animal3, animal4, animal5};
        AbstractAnimal[] result = searchService.findDuplicate(animals);

        assertArrayEquals(result, new AbstractAnimal[]{animal1, animal3});
    }
}
