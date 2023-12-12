package ru.mts;

/**
 * Class Order
 * goodsAmount - Number of goods in order
 * goodsCost - Cost of goods in order
 * discount - Discount for total sum in order
 */
public class Order {
    private int goodsAmount;  // Amount of goods in order
    private double goodsCost;   // Sum of good in order
    private double discount;    // Discount for total sum in order

    // Constructor
    public Order(int amountOfGoods, double goodsCost, double discount) {
            this.goodsAmount = amountOfGoods;
            this.goodsCost = goodsCost;
            this.discount = discount;
    }

    public int getGoodsAmount() {
        return goodsAmount;
    }

    public void setGoodsAmount(int goodsAmount) {
        this.goodsAmount = goodsAmount;
    }

    public double getGoodsCost() {
        return goodsCost;
    }

    public void setGoodsCost(double goodsCost) {
        this.goodsCost = goodsCost;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
}
