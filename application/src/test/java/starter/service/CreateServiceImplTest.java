package starter.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.mts.Main;
import ru.mts.animal.*;
import ru.mts.service.CreateServiceImpl;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = Main.class)
public class CreateServiceImplTest {

    @Autowired
    private CreateServiceImpl createService;

    @Test
    void testCreatAnimalsCapacity() {
        createService.createAnimals().forEach((type, animalList) -> {
            for (AbstractAnimal animal : animalList) {
                if (type.equals(AnimalsEnum.CAT.name())) {
                    assertTrue(animal instanceof Cat);
                }
                if (type.equals(AnimalsEnum.DOG.name())) {
                    assertTrue(animal instanceof Dog);
                }
                if (type.equals(AnimalsEnum.WOLF.name())) {
                    assertTrue(animal instanceof Wolf);
                }
            }
        });

    }
}
