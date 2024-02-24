package application;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import ru.mts.Main;
import ru.mts.animal.AbstractAnimal;
import ru.mts.factory.AnimalProperties;
import ru.mts.repository.AnimalRepository;
import ru.mts.repository.AnimalRepositoryImpl;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        Set<AbstractAnimal> duplicates = animalRepository.findDuplicate();
    }

    @Test
    public void testFindOlderAnimals(){
        int year = 10;

        AbstractAnimal[] olderAnimals = animalRepository.findOlderAnimal(year);

        for (AbstractAnimal animal : olderAnimals) {
            int yearDif = LocalDate.now().getYear() - animal.getBirthDate().getYear();
            int dayDif = LocalDate.now().getDayOfYear() - animal.getBirthDate().getDayOfYear();
            assertTrue((yearDif > year) || (yearDif == year && dayDif >= 0));
        }
    }
}
