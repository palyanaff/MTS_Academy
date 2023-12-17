package ru.mts.service;

public class CreateAnimalServiceImpl implements CreateAnimalService {
    public void createAnimal(int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(setAnimal(i).toString());
        }
    }

    @Override
    public void createAnimal() {
        int i = 0;
        do {
            System.out.println(setAnimal(i).toString());
            i++;
        } while (i < 10);
    }
}
