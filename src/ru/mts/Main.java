package ru.mts;

public class Main {
    public static void main(String[] args) {
        CreateAnimalServiceImpl service = new CreateAnimalServiceImpl();
        service.createAnimal();
        service.createAnimal(5);
    }
}
