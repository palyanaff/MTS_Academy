package ru.mts;

public class CreateAnimalServiceImpl implements CreateAnimalService {
    public void createAnimal(int n) {
        for (int i = 0; i < n; i++) {
            AbstractAnimal animal = setAnimal(i);
            System.out.println(animal.toString());
        }
    }

    @Override
    public void createAnimal() {
        int i = 0;
        do {
            AbstractAnimal animal = setAnimal(i);
            System.out.println(animal.toString());
            i++;
        } while (i < 10);
    }
}
