package ru.mts.animal;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Abstract class that contains main logic of predator
 *
 * @author palyanaff
 * @version 1.0
 */
abstract public class Predator extends AbstractAnimal {
    /**
     * Predator location
     */
    protected String location;

    /**
     * Constructor for predator class
     *
     * @param breed     breed of predator as String
     * @param name      name of predator as String
     * @param cost      cost of predator as BigDecimal
     * @param character character of predator as String
     * @param birthDate birthdate of predator as LocalDate
     * @param location  location of predator as String
     */
    public Predator(String breed, String name, BigDecimal cost, String character, LocalDate birthDate, String location) {
        super(breed, name, cost, character, birthDate);
        this.location = location;
    }

    /**
     * Method of predator bite
     */
    public void bite() {
        System.out.printf("%s %s bite\n", breed, name);
    }

    /**
     * Getter for predator location
     *
     * @return location {@link Predator#location} as String
     */
    public String getLocation() {
        return location;
    }

    /**
     * Setter for predator location{@link Predator#location}
     *
     * @param location location of predator as String
     */
    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Predator{" +
                "breed='" + breed + '\'' +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", character='" + character + '\'' +
                ", birthDate=" + getFormattedDate(birthDate) +
                ", location='" + location + '\'' +
                '}';
    }
}
