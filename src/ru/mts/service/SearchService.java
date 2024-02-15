package ru.mts.service;

import ru.mts.animal.AbstractAnimal;

public interface SearchService {
    /**
     * Method for finding leap years in array of {@link AbstractAnimal}
     *
     * @param animals array of {@link AbstractAnimal}
     * @return array of String with animals name
     */
    String[] findLeapYearNames(AbstractAnimal[] animals);

    /**
     * Method for finding animals which are older than N years
     *
     * @param animals array of {@link AbstractAnimal}
     * @param N       year to compare
     * @return array of {@link AbstractAnimal} which are older than N years
     */
    AbstractAnimal[] findOlderAnimal(AbstractAnimal[] animals, int N);

    /**
     * Method for finding duplicates in array of {@link AbstractAnimal}
     *
     * @param animals array of {@link AbstractAnimal}
     */
    AbstractAnimal[] findDuplicate(AbstractAnimal[] animals);

    /**
     * Method for printing duplicates in array of {@link AbstractAnimal}
     *
     * @param animals array of {@link AbstractAnimal}
     */
    void printDuplicate(AbstractAnimal[] animals);
}
