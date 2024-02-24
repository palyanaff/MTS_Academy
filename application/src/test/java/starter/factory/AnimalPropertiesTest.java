package starter.factory;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import ru.mts.Main;
import ru.mts.factory.AnimalProperties;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

@SpringBootTest(classes = Main.class)
@ActiveProfiles("test")
public class AnimalPropertiesTest {
    @Test
    public void testStart() {
    }

    @Autowired
    private AnimalProperties animalProperties;

    @Test
    void testGetCatNames() {
        String[] catNames = animalProperties.getCatNames().toArray(new String[0]);
        String[] resNames = new String[]{
                "testBarsik",
                "testKitik",
                "testMusya",
                "testSnejok"
        };
        assertArrayEquals(catNames, resNames);
    }

    @Test
    void testGetDogNames() {
        String[] dogNames = animalProperties.getDogNames().toArray(new String[0]);
        String[] resNames = new String[]{
                "testDrujok",
                "testDogg",
                "testLoky",
                "testVitek"
        };
        assertArrayEquals(dogNames, resNames);
    }

    @Test
    void testGetWolfNames() {
        String[] wolfNames = animalProperties.getWolfNames().toArray(new String[0]);
        String[] resNames = new String[]{
                "testAlpha",
                "testSummer",
                "testGhost",
                "testNimeriya"
        };
        assertArrayEquals(wolfNames, resNames);
    }
}