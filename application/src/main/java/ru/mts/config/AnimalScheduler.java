package ru.mts.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import ru.mts.repository.AnimalRepository;

import java.util.Arrays;

@Component
public class AnimalScheduler {
    @Autowired
    private AnimalRepository animalRepository;

    @Scheduled(fixedDelay = 60000L)
    public void doScheduled(){
        System.out.println(Arrays.toString(animalRepository.findLeapYearNames()));
        System.out.println(Arrays.toString(animalRepository.findOlderAnimal(10)));
        animalRepository.printDuplicate();
    }
}
