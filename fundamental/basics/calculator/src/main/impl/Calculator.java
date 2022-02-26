package com.epam.trainning.ngocnhung.fundamental.basics.calculator.src.main.impl;

import com.epam.trainning.ngocnhung.fundamental.basics.calculator.src.main.ICalculator;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Calculator implements ICalculator {

    private final int precision;

    public Calculator(int precision) {
        this.precision = precision;
    }

    public double rounded(double result) {
        result = BigDecimal.valueOf(result).setScale(precision, RoundingMode.HALF_UP).doubleValue();
        return result;
    }

    @Override
    public double add(double a, double b) {
        if (a == Double.MAX_VALUE && b == Double.MAX_VALUE) {
            return Double.POSITIVE_INFINITY;
        }
        if (a == -Double.MAX_VALUE && b == -Double.MAX_VALUE) {
            return Double.NEGATIVE_INFINITY;
        }
        try {
            return rounded(a + b);
        } catch (NumberFormatException e) {
            System.out.printf("Please enter proper numbers!");
        }
        return rounded(a + b);
    }


    @Override
    public double subtract(double a, double b) {
        if (a == -Double.MAX_VALUE && b == Double.MAX_VALUE) {
            return Double.NEGATIVE_INFINITY;
        }
        if (a == Double.MAX_VALUE && b == -Double.MAX_VALUE) {
            return Double.POSITIVE_INFINITY;
        }
        try {
            return rounded(a - b);
        } catch (NumberFormatException e) {
            System.out.println("Please enter proper numbers!");
        }
        return rounded(a - b);
    }

    @Override
    public double multiply(double a, double b) {
        if (a == Double.MAX_VALUE && b == Double.MAX_VALUE) {
            return Double.POSITIVE_INFINITY;
        }
        if ((a == -Double.MAX_VALUE && b == Double.MAX_VALUE) || (a == Double.MAX_VALUE && b == -Double.MAX_VALUE)) {
            return Double.NEGATIVE_INFINITY;
        }
        try {
            return rounded(a * b);
        } catch (NumberFormatException e) {
            System.out.println("Please enter proper numbers!");
        }
        return rounded(a * b);
    }

    @Override
    public double divide(double a, double b) {
        if (a > 0 && b == 0.0) {
            return Double.POSITIVE_INFINITY;
        }
        if (a < 0 && b == 0.0) {
            return Double.NEGATIVE_INFINITY;
        }
        try {
            return rounded(a / b);
        } catch (NumberFormatException e) {
            System.out.println("Please enter proper numbers!");
        }
        return rounded(a / b);
    }
}
