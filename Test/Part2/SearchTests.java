package Part2;

import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import ru.mts.animal.AbstractAnimal;
import ru.mts.animal.Cat;
import ru.mts.animal.Dog;
import ru.mts.animal.Wolf;
import ru.mts.service.SearchServiceImpl;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SearchTests {

    private static SearchServiceImpl searchService;

    @BeforeAll
    public static void beforeAll() {
        searchService = new SearchServiceImpl();
    }


    @Test
    @DisplayName("Find leap year names test")
    public void findLeapYearNamesTest() {
        int i = 0;
        AbstractAnimal cat1 = new Cat("White", "Barsik " + i++, new BigDecimal("0"),
                "Cat", LocalDate.of(2000, 1, 1), "Saint Petersburg");
        AbstractAnimal dog1 = new Dog("Husky", "Lucky " + i++, new BigDecimal(0),
                "Dog", LocalDate.of(2001, 1, 1), "Moscow");
        AbstractAnimal wolf1 = new Wolf("Grey", "Wolf " + i++, new BigDecimal(0),
                "Wolf", LocalDate.of(2002, 1, 1), "Forest");
        AbstractAnimal cat2 = new Cat("White", "Barsik " + i++, new BigDecimal("0"),
                "Cat", LocalDate.of(2003, 1, 1), "Saint Petersburg");
        AbstractAnimal dog2 = new Dog("Husky", "Lucky " + i++, new BigDecimal(0),
                "Dog", LocalDate.of(2004, 1, 1), "Moscow");
        AbstractAnimal wolf2 = new Wolf("Grey", "Wolf " + i++, new BigDecimal(0),
                "Wolf", LocalDate.of(2005, 1, 1), "Forest");


        AbstractAnimal[] animals = new AbstractAnimal[]{cat1, cat2, dog1, dog2, wolf1, wolf2};

        String[] result = searchService.findLeapYearNames(animals);
        assertArrayEquals(result, new String[]{cat1.getName(), dog2.getName()});
    }

    @Test
    @DisplayName("Find leap year names test")
    public void findLeapYearNamesTest() {
        int i = 0;
        AbstractAnimal cat1 = new Cat("White", "Barsik " + i++, new BigDecimal("0"),
                "Cat", LocalDate.of(2000, 1, 1), "Saint Petersburg");
        AbstractAnimal dog1 = new Dog("Husky", "Lucky " + i++, new BigDecimal(0),
                "Dog", LocalDate.of(2001, 1, 1), "Moscow");
        AbstractAnimal wolf1 = new Wolf("Grey", "Wolf " + i++, new BigDecimal(0),
                "Wolf", LocalDate.of(2002, 1, 1), "Forest");
        AbstractAnimal cat2 = new Cat("White", "Barsik " + i++, new BigDecimal("0"),
                "Cat", LocalDate.of(2003, 1, 1), "Saint Petersburg");
        AbstractAnimal dog2 = new Dog("Husky", "Lucky " + i++, new BigDecimal(0),
                "Dog", LocalDate.of(2004, 1, 1), "Moscow");
        AbstractAnimal wolf2 = new Wolf("Grey", "Wolf " + i++, new BigDecimal(0),
                "Wolf", LocalDate.of(2005, 1, 1), "Forest");


        AbstractAnimal[] animals = new AbstractAnimal[]{cat1, cat2, dog1, dog2, wolf1, wolf2};

        String[] result = searchService.findLeapYearNames(animals);
        assertArrayEquals(result, new String[]{cat1.getName(), dog2.getName()});
    }
}
