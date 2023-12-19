package ru.mts.service;

/**
 * Class for creating unique animals that extends {@link ru.mts.animal.AbstractAnimal}
 *
 * @author palyanaff
 * @version 1.0
 */
public class CreateAnimalServiceImpl implements CreateAnimalService {
    /**
     * Create n of unique animals
     *
     * @param n number of unique animals
     * @see CreateAnimalServiceImpl#createAnimal()
     */
    public void createAnimal(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(setAnimal(i).toString());
        }
    }

    /**
     * Create 10 unique animals
     * @see CreateAnimalServiceImpl#createAnimal(int n)
     */
    @Override
    public void createAnimal() {
        int i = 0;
        do {
            System.out.println(setAnimal(i).toString());
            i++;
        } while (i < 10);
    }
}
