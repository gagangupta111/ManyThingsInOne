package com.test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.Locale;

public class DoubleFloat {

    public static String formatRupees(double value) {
        NumberFormat format = NumberFormat.getCurrencyInstance(new Locale("en", "us"));
        format.setMinimumFractionDigits(2);
        format.setMaximumFractionDigits(2);
        format.setRoundingMode(RoundingMode.HALF_EVEN);
        return format.format(value);
    }

    public static void main(String[] args) {

        double total = 0.2;
        for (int i = 0; i < 100; i++) {
            total += 0.2;
        }
        System.out.println("total = " + (total));
        System.out.println("total in rupees = " + formatRupees(total));

        BigDecimal tempBig = new BigDecimal(22.12);
        System.out.println("tempBig = " + formatRupees(tempBig.doubleValue()));

    }

}
