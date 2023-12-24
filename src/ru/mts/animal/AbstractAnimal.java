package ru.mts.animal;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * Abstract class that contains main logic of animals
 *
 * @author palyanaff
 * @version 1.0
 */
abstract public class AbstractAnimal implements Animal {
    /**
     * Animal breed
     */
    protected String breed;
    /**
     * Animal name
     */
    protected String name;
    /**
     * Animal cost
     */
    protected BigDecimal cost;
    /**
     * Animal character
     */
    protected String character;

    /**
     * Animal birthdate
     */
    protected LocalDate birthDate;

    /**
     * Constructor for abstract animal class
     *
     * @param breed     breed of predator as String
     * @param name      name of predator as String
     * @param cost      cost of predator as BigDecimal
     * @param character character of predator as String
     */
    public AbstractAnimal(String breed, String name, BigDecimal cost, String character, LocalDate birthDate) {
        this.breed = breed;
        this.name = name;
        this.cost = cost.setScale(2, RoundingMode.HALF_UP);
        this.character = character;
        this.birthDate = birthDate;
    }

    @Override
    public String getBreed() {
        return breed;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public BigDecimal getCost() {
        return cost;
    }

    @Override
    public String getCharacter() {
        return character;
    }

    @Override
    public LocalDate getBirthDate() {
        return birthDate;
    }

    /**
     * Method for determine equals Animals
     *
     * @param o Animal to compare
     * @return true if Animals are equals, false if not
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractAnimal that = (AbstractAnimal) o;
        return Objects.equals(breed, that.breed) && Objects.equals(name, that.name) && Objects.equals(birthDate, that.birthDate);
    }

    @Override
    public String toString() {
        return "AbstractAnimal{" +
                "breed='" + breed + '\'' +
                ", name='" + name + '\'' +
                ", cost=" + cost +
                ", character='" + character + '\'' +
                ", birthDate=" + getFormattedDate(birthDate) +
                '}';
    }

    /**
     * Method for formatting LocalDate in dd-MM-yyyy format
     *
     * @param date LocalDate in yyyy-mm-dd format
     * @return LocalDate in dd-MM-yyyy format
     */
    public String getFormattedDate(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return date.format(formatter);
    }
}
