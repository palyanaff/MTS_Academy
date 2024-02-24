package ru.mts.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.mts.repository.AnimalRepository;

import java.util.Arrays;

@Component
public class AnimalScheduler {
    private final AnimalRepository animalRepository;

    public AnimalScheduler(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @Scheduled(fixedDelay = 60000L)
    public void doScheduled(){
        System.out.println(animalRepository.findLeapYearNames().toString());
        System.out.println(animalRepository.findOlderAnimal(10).toString());
        animalRepository.printDuplicate();
    }
}
