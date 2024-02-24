package starter.factory;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import ru.mts.Main;
import ru.mts.animal.Cat;
import ru.mts.animal.Dog;
import ru.mts.animal.Wolf;
import ru.mts.factory.AnimalProperties;
import ru.mts.factory.CatFactory;
import ru.mts.factory.DogFactory;
import ru.mts.factory.WolfFactory;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = Main.class)
@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public class FactoryTest {

    @Autowired
    private AnimalProperties animalProperties;
    @Test
    public void testCatFactory(@Mock CatFactory catFactory) {
        Mockito.doReturn(new Cat(
                "White", animalProperties.getCatNames().get(0), BigDecimal.ZERO,
                "Cat", LocalDate.now(), "Saint Petersburg"
        )).when(catFactory).createAnimal();

        assertTrue(catFactory.createAnimal() instanceof Cat
                && animalProperties.getCatNames().get(0).equals("testBarsik"));
    }

    @Test
    public void testWolfFactory(@Mock WolfFactory wolfFactory) {
        Mockito.doReturn(new Wolf(
                "Grey", animalProperties.getWolfNames().get(0),BigDecimal.ZERO,
                "Wolf", LocalDate.now(), "Forest")
        ).when(wolfFactory).createAnimal();

        assertTrue(wolfFactory.createAnimal() instanceof Wolf
                && animalProperties.getWolfNames().get(0).equals("testAlpha"));
    }

    @Test
    public void testDogFactory(@Mock DogFactory dogFactory) {
        Mockito.doReturn(new Dog(
                "Husky", animalProperties.getDogNames().get(0), BigDecimal.ZERO,
                "Dog", LocalDate.now(), "Moscow"
        )).when(dogFactory).createAnimal();

        assertTrue(dogFactory.createAnimal() instanceof Dog
                && animalProperties.getDogNames().get(0).equals("testDrujok"));
    }
}
