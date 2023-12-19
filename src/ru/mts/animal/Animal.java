package ru.mts.animal;

import java.math.BigDecimal;

/**
 * Interface realize the most common methods of Animal classes
 *
 * @author palyanaff
 * @version 1.0
 */
public interface Animal {
    /**
     * Getter for animal breed
     *
     * @return breed as String
     */
    String getBreed();

    /**
     * Getter for animal name
     *
     * @return name as String
     */
    String getName();

    /**
     * Getter for animal cost
     *
     * @return cost as BigDecimal
     */
    BigDecimal getCost();

    /**
     * Getter for animal character
     *
     * @return character as String
     */
    String getCharacter();
}
