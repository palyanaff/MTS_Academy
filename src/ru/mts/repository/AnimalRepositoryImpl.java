package ru.mts.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import ru.mts.animal.AbstractAnimal;
import ru.mts.service.CreateServiceImpl;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Repository
@Scope(value = "singleton")
public class AnimalRepositoryImpl implements AnimalRepository {

    private AbstractAnimal[] animals;

    @Autowired
    public CreateServiceImpl createService;

    @PostConstruct
    private void initService() {
        animals = createService.createAnimals(10);
    }

    @Override
    public String[] findLeapYearNames() {
        String[] temp = new String[animals.length];
        int resLength = 0;
        for (AbstractAnimal animal : animals) {
            if (animal.getBirthDate().isLeapYear()) {
                temp[resLength++] = animal.getName();
            }
        }
        String[] result = new String[resLength];
        System.arraycopy(temp, 0, result, 0, resLength);
        return result;
    }

    @Override
    public AbstractAnimal[] findOlderAnimal(int N) {
        AbstractAnimal[] temp = new AbstractAnimal[animals.length];
        int resLength = 0;
        for (AbstractAnimal animal : animals) {
            int yearDif = LocalDate.now().getYear() - animal.getBirthDate().getYear();
            int dayDif = LocalDate.now().getDayOfYear() - animal.getBirthDate().getDayOfYear();
            if ((yearDif > N) || (yearDif == N && dayDif >= 0)) {
                temp[resLength++] = animal;
            }
        }

        AbstractAnimal[] result = new AbstractAnimal[resLength];
        System.arraycopy(temp, 0, result, 0, resLength);
        return result;
    }

    @Override
    public Set<AbstractAnimal> findDuplicate() {
        AbstractAnimal[] temp = new AbstractAnimal[animals.length];
        int resLength = 0;
        for (int i = 0; i < animals.length; i++) {
            for (int j = 0; j < i; j++) {
                if (animals[i].equals(animals[j])) {
                    temp[resLength++] = animals[j];
                }
            }
        }
        return new HashSet<>(Arrays.asList(temp)) ;
    }

    @Override
    public void printDuplicate() {
        for (AbstractAnimal animal : findDuplicate()) {
            System.out.println(animal);
        }
    }
}
