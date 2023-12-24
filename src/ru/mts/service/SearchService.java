package ru.mts.service;

import ru.mts.animal.AbstractAnimal;

public interface SearchService {
    String[] findLeapYearNames(AbstractAnimal[] animals);

    AbstractAnimal[] findOlderAnimal(AbstractAnimal[] animals, int N);

    void findDuplicate(AbstractAnimal[] animals);
}
