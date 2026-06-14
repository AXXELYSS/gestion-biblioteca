package com.biblioteca.strategy;

public class StudentPenaltyStrategy implements PenaltyStrategy {
    private static final double DISCOUNT = 0.50;

    @Override
    public double applyDiscount(double baseAmount) {
        return baseAmount * (1 - DISCOUNT);
    }
}