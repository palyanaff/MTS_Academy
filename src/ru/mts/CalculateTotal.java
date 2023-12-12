package ru.mts;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Utility class CalculateTotal
 * method printTotal - print total sum and total sum with discount
 */
public final class CalculateTotal {
    // Method for printing total sum and total sum with discount
    public static void printTotal(Order order) {
        if (order.getGoodsAmount() > 0 && order.getGoodsCost() > 0) {
            BigDecimal totalSumD = BigDecimal.valueOf(order.getGoodsCost() * order.getGoodsAmount());
            BigDecimal totalSumWithDiscountD = BigDecimal.valueOf(totalSumD.doubleValue() * (1 - order.getDiscount() / 100.0));

            System.out.printf("Total cost of %d goods: %.2f\n", order.getGoodsAmount(), totalSumD.setScale(2, RoundingMode.HALF_UP));
            System.out.printf("Total cost of %d goods with discount: %.2f\n", order.getGoodsAmount(), totalSumWithDiscountD.setScale(2, RoundingMode.HALF_UP));
        } else {
            System.err.println("ERROR: Wrong input");
        }
    }
}
