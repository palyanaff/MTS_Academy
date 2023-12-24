package ru.mts.service;

import ru.mts.animal.AbstractAnimal;

import java.time.LocalDate;

/**
 * Class for searching in array of animals that extends {@link ru.mts.animal.AbstractAnimal}
 *
 * @author palyanaff
 * @version 1.0
 */
public class SearchServiceImpl implements SearchService {
    @Override
    public String[] findLeapYearNames(AbstractAnimal[] animals) {
        String[] temp = new String[animals.length];
        int resLength = 0;
        for (AbstractAnimal animal : animals) {
            if (animal.getBirthDate().isLeapYear()) {
                temp[resLength++] = animal.getName();
            }
        }
        String[] result = new String[resLength];
        for (int i = 0; i < resLength; i++) {
            result[i] = temp[i];
        }
        return result;
    }

    @Override
    public AbstractAnimal[] findOlderAnimal(AbstractAnimal[] animals, int N) {
        AbstractAnimal[] temp = new AbstractAnimal[animals.length];
        int resLength = 0;
        for (AbstractAnimal animal : animals) {
            if (LocalDate.now().getYear() - animal.getBirthDate().getYear() > N) {
                temp[resLength++] = animal;
            }
        }
        AbstractAnimal[] result = new AbstractAnimal[resLength];
        for (int i = 0; i < resLength; i++) {
            result[i] = temp[i];
        }
        return result;
    }

    @Override
    public void findDuplicate(AbstractAnimal[] animals) {
        for (int i = 0; i < animals.length; i++) {
            for (int j = 0; j < i; j++) {
                if (animals[i].equals(animals[j])) {
                    System.out.println(animals[i] + " equals " + animals[j]);
                }
            }
        }
    }
}
