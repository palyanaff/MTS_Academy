package ru.mts.repository;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import ru.mts.animal.AbstractAnimal;
import ru.mts.service.CreateService;
import ru.mts.service.CreateServiceImpl;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.*;

@Repository
@Scope(value = "singleton")
public class AnimalRepositoryImpl implements AnimalRepository {

    private Map<String, List<AbstractAnimal>> animals;

    public final CreateService createService;

    public AnimalRepositoryImpl(CreateService createService) {
        this.createService = createService;
        animals = createService.createAnimals();
    }

    @PostConstruct
    private void initService() {

    }

    @Override
    public Map<String, LocalDate> findLeapYearNames() {
        Map<String, LocalDate> result = new HashMap<>();
        animals.forEach((animalType, animalsList) -> {
            for (AbstractAnimal animal : animalsList) {
                if (animal.getBirthDate().isLeapYear()) {
                    result.put(animalType + " " + animal.getName(), animal.getBirthDate());
                }
            }
        });
        return result;
    }

    @Override
    public Map<AbstractAnimal, Integer> findOlderAnimal(int N) {
        Map<AbstractAnimal, Integer> result = new HashMap<>();
        final AbstractAnimal[] oldestAnimal = {null};
        animals.forEach((animalType, animalsList) -> {
            for (AbstractAnimal animal : animalsList) {
                int yearDif = LocalDate.now().getYear() - animal.getBirthDate().getYear();
                int dayDif = LocalDate.now().getDayOfYear() - animal.getBirthDate().getDayOfYear();
                if ((yearDif > N) || (yearDif == N && dayDif >= 0)) {
                    result.put(animal, yearDif);
                } else {
                    if (oldestAnimal[0] == null) {
                        oldestAnimal[0] = animal;
                    }

                    int oldestYearDif = LocalDate.now().getYear() - oldestAnimal[0].getBirthDate().getYear();
                    int oldestDayDif = LocalDate.now().getDayOfYear() - oldestAnimal[0].getBirthDate().getDayOfYear();

                    if ((yearDif > oldestYearDif) || (yearDif == oldestYearDif && oldestDayDif >= 0)) {
                        oldestAnimal[0] = animal;
                    }
                }
            }

        });
        if (result.isEmpty()) {
            int yearDif = LocalDate.now().getYear() - oldestAnimal[0].getBirthDate().getYear();
            int dayDif = LocalDate.now().getDayOfYear() - oldestAnimal[0].getBirthDate().getDayOfYear();

            result.put(oldestAnimal[0], dayDif < 0 ? yearDif - 1 : yearDif);
        }
        return result;
    }

    @Override
    public Map<String, Integer> findDuplicate() {
        Map<String, Integer> result = new HashMap<>();
        animals.forEach((animalType, animalsList) -> {
            int duplicateCounter = 0;
            for (int i = 0; i < animalsList.size(); i++) {
                for (int j = 0; j < i; j++) {
                    if (animalsList.get(i).equals(animalsList.get(j))) {
                        duplicateCounter++;
                    }
                }
            }
            result.put(animalType, duplicateCounter);
        });
        return result;
    }

    @Override
    public void printDuplicate() {
        findDuplicate().forEach((animalType, duplicateCount) -> {
            System.out.println(animalType + "=" + duplicateCount);
        });
    }
}
