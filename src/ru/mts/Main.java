package ru.mts;

import ru.mts.service.CreateAnimalServiceImpl;

public class Main {
    public static void main(String[] args) {
        CreateAnimalServiceImpl service = new CreateAnimalServiceImpl();
        service.createAnimal();
        service.createAnimal(5);
    }
}
