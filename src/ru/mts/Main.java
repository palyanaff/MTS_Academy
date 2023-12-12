package ru.mts;

public class Main {
    public static void main(String[] args) {
        CalculateTotal.printTotal(new Order(2,2.53,0.75));
        CalculateTotal.printTotal(new Order(5, 13.534, 42.575));
        CalculateTotal.printTotal(new Order(3, 4.215, 59.1));
    }
}
