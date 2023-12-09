package ru.mts;

/**
 * Class Order
 * goodsAmount - number of goods in order
 * goodSum - Sum of good in order
 * discount - Discount for total sum in order
 */
public class Order {
    private int goodsAmount;  // Amount of goods in order
    private double goodSum;   // Sum of good in order
    private double discount;    // Discount for total sum in order

    // Constructor
    public Order(int amountOfGoods, double sumOfGood, double discount) {
            this.goodsAmount = amountOfGoods;
            this.goodSum = sumOfGood;
            this.discount = discount;
    }

    // Method for printing total sum and total sum with discount
    public static void printTotal(Order order) {
        if (order.goodsAmount > 0 || order.goodSum > 0) {
            double totalSum = Math.round(order.goodSum * order.goodsAmount * 100.0) / 100.0;
            double roundDiscount = Math.round((1 - order.discount / 100.0) * 100.0) / 100.0;
            double totalSumWithDiscount = Math.round(totalSum * roundDiscount * 100.0) / 100.0;

            System.out.printf("Total cost of %d goods: %.2f\n", order.goodsAmount, totalSum);
            System.out.printf("Total cost of %d goods with discount: %.2f\n", order.goodsAmount, totalSumWithDiscount);
        } else {
            System.out.println("ERROR: Wrong input");
        }
    }
}
