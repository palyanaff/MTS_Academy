package ru.mts;

public class Main {
    public static void main(String[] args) {
        Order.printTotal(new Order(2,2.53,0.75));
        Order.printTotal(new Order(5, 13.534, 42.575));
        Order.printTotal(new Order(3, 4.215, 59.1));
    }
}
