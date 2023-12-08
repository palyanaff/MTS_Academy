package ru.mts;

public class Main {
    public static void main(String[] args) {
        Order mainOrder = new Order(2,2.53,0.75);
        mainOrder.printTotal(mainOrder);
        mainOrder.printTotal(new Order(5, 13.534, 42.575));
        mainOrder.printTotal(new Order(3, 4.215, 59.1));
    }
}
