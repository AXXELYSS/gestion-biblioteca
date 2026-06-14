package com.biblioteca.strategy;

public class RegularPenaltyStrategy implements PenaltyStrategy {
    @Override
    public double applyDiscount(double baseAmount) {
        return baseAmount;
    }
}