package ru.mts.repository;

import org.springframework.stereotype.Repository;
import ru.mts.animal.AbstractAnimal;

import java.util.Set;

/**
 * Interface for repository which works with {@link AbstractAnimal}
 *
 * @author palyanaff
 * @version 1.0
 */
@Repository
public interface AnimalRepository {
    /**
     * Method for finding leap years in array of {@link AbstractAnimal}
     *
     * @return array of String with animals name
     */
    String[] findLeapYearNames();

    /**
     * Method for finding animals which are older than N years
     *
     * @param N year to compare
     * @return array of {@link AbstractAnimal} which are older than N years
     */
    AbstractAnimal[] findOlderAnimal(int N);

    /**
     * Method for finding duplicates in array of {@link AbstractAnimal}
     *
     * @return set of duplicates
     */
    Set<AbstractAnimal> findDuplicate();

    /**
     * Method for printing duplicates in array of {@link AbstractAnimal}
     */
    void printDuplicate();
}
