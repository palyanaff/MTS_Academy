package Part1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.mts.animal.AbstractAnimal;
import ru.mts.animal.Cat;
import ru.mts.animal.Dog;
import ru.mts.animal.Wolf;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AbstractAnimalTests {
    @Test
    @DisplayName("Equals test")
    public void testEquals() {
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
        AbstractAnimal animalNull = null;

        assertFalse(animal1.equals(animal2));
        assertTrue(animal2.equals(animal2));
        assertTrue(animal3.equals(animal4));
        assertFalse(animal3.equals(animal5));
        assertFalse(animal3.equals(null));
        assertFalse(animal3.equals(animalNull));
    }
}
