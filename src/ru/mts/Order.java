package ru.mts;

/**
 * Class Order
 * amountOdGoods - number of goods in order
 * sumOfGood - Sum of good in order
 * discount - Discount for total sum in order
 */
public class Order {
    private int amountOfGoods;  // Amount of goods in order
    private double sumOfGood;   // Sum of good in order
    private double discount;    // Discount for total sum in order

    // Constructor
    public Order(int amountOfGoods, double sumOfGood, double discount) {
        this.amountOfGoods = amountOfGoods;
        this.sumOfGood = sumOfGood;
        this.discount = discount;
    }

    // Method for printing total sum and total sum with discount
    public void printTotal(Order order) {
        double totalSum = Math.round(order.sumOfGood * order.amountOfGoods * 100.0) / 100.0;
        double roundDiscount = Math.round((1 - order.discount / 100.0) * 100.0) / 100.0;
        double totalSumWithDiscount = Math.round(totalSum * roundDiscount * 100.0) / 100.0;

        System.out.println("Total cost of " + order.amountOfGoods + " goods: " + totalSum);
        System.out.println("Total cost of " + order.amountOfGoods + " goods with discount: " + totalSumWithDiscount);
    }
}
