package starter.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.mts.Main;
import ru.mts.animal.Cat;
import ru.mts.factory.CatFactory;
import ru.mts.service.CreateServiceImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(classes = Main.class)
public class CreateServiceImplTest {

    @Autowired
    private CreateServiceImpl createService;

    @Test
    void testCreatAnimalsCapacity() {
        assertEquals(10, createService.createAnimals().length);
    }
}
