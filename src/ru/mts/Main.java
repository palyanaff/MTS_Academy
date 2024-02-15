package ru.mts;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import ru.mts.animal.AbstractAnimal;
import ru.mts.animal.Cat;
import ru.mts.animal.Dog;
import ru.mts.repository.AnimalRepository;
import ru.mts.repository.AnimalRepositoryImpl;
import ru.mts.service.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@ComponentScan("ru")
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);

        AnimalRepository repository = context.getBean(AnimalRepositoryImpl.class);

        System.out.println("Leap years:");
        String[] leapYear = repository.findLeapYearNames();
        for (String name : leapYear) {
            System.out.print(name + " ");
        }
        System.out.println();

        System.out.println("Older:");
        AbstractAnimal[] older = repository.findOlderAnimal(10);
        for (AbstractAnimal animal : older) {
            System.out.println(animal);
        }

        System.out.println("Duplicates:");
        repository.printDuplicate();
    }
}
