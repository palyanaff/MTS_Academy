package ru.mts;

import ru.mts.animal.AbstractAnimal;
import ru.mts.service.CreateServiceImpl;
import ru.mts.service.SearchServiceImpl;

public class Main {
    public static void main(String[] args) {
        CreateServiceImpl createService = new CreateServiceImpl();
        SearchServiceImpl searchService = new SearchServiceImpl();

        AbstractAnimal[] animals = createService.createAnimals(100);

        String[] leapYear = searchService.findLeapYearNames(animals);
        for (String name : leapYear) {
            System.out.print(name + " ");
        }
        System.out.println();

        AbstractAnimal[] older = searchService.findOlderAnimal(animals, 10);
        for (AbstractAnimal animal : older) {
            System.out.println(animal);
        }

        System.out.println("Duplicates:");
        searchService.findDuplicate(animals);
    }
}
