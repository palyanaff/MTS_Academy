package ru.mts;

/**
 * Utility class CalculateTotal
 * method printTotal - print total sum and total sum with discount
 */
public final class CalculateTotal {
    // Method for printing total sum and total sum with discount
    public static void printTotal(Order order) {
        if (order.getGoodsAmount() > 0 && order.getGoodsCost() > 0) {
            double totalSum = Math.round(order.getGoodsCost() * order.getGoodsAmount() * 100.0) / 100.0;
            double roundDiscount = Math.round((1 - order.getDiscount() / 100.0) * 100.0) / 100.0;
            double totalSumWithDiscount = Math.round(totalSum * roundDiscount * 100.0) / 100.0;

            System.out.printf("Total cost of %d goods: %.2f\n", order.getGoodsAmount(), totalSum);
            System.out.printf("Total cost of %d goods with discount: %.2f\n", order.getGoodsAmount(), totalSumWithDiscount);
        } else {
            System.err.println("ERROR: Wrong input");
        }
    }
}
