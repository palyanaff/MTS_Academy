package Part1;

import org.junit.Assert;
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

public class AbstractAnimalTests {
    @Test
    @DisplayName("Equals test")
    public void equalsTest() {
        AbstractAnimal animal1 = new Cat("White", "Barsik", new BigDecimal("0"),
                "Cat", LocalDate.of(2000, 1, 1), "Saint Petersburg");
        AbstractAnimal animal2 = new Dog("Husky", "Lucky", new BigDecimal(0),
                "Dog", LocalDate.of(2001, 1, 1), "Moscow");
        AbstractAnimal animal3 = new Wolf("Grey", "Wolf", new BigDecimal(0),
                "Wolf", LocalDate.of(2002, 1, 1), "Forest");
        AbstractAnimal animal4 = new Wolf("Grey", "Wolf", new BigDecimal(0),
                "Wolf", LocalDate.of(2002, 1, 1), "Forest");
        AbstractAnimal animal5 = new Wolf("Grey1", "Wolf", new BigDecimal(0),
                "Wolf", LocalDate.of(2002, 1, 1), "Forest");

        Assertions.assertFalse(animal1.equals(animal2));
        Assertions.assertTrue(animal2.equals(animal2));
        Assertions.assertTrue(animal3.equals(animal4));
        Assertions.assertFalse(animal3.equals(animal5));
    }
}
