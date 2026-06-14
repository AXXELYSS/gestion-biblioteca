package com.biblioteca.service;

import com.biblioteca.domain.BookLoan;
import com.biblioteca.strategy.PenaltyStrategy;
import java.util.List;

public class LibraryFineService {
    private final PenaltyStrategy penaltyStrategy; // Inyección de dependencia

    public LibraryFineService(PenaltyStrategy penaltyStrategy) {
        this.penaltyStrategy = penaltyStrategy;
    }

    public double calculateTotalFine(List<BookLoan> loans, double dailyTariff) {
        validateInputs(loans, dailyTariff);

        // Uso de programación declarativa con Streams de Java
        double totalBaseFine = loans.stream()
                .mapToDouble(loan -> loan.getDaysOverdue() * dailyTariff)
                .sum();

        return penaltyStrategy.applyDiscount(totalBaseFine);
    }

    // Validación defensiva (Principio Fail-Fast)
    private void validateInputs(List<BookLoan> loans, double dailyTariff) {
        if (loans == null || loans.isEmpty()) {
            throw new IllegalArgumentException("La lista de préstamos no puede estar vacía.");
        }
        if (dailyTariff <= 0) {
            throw new IllegalArgumentException("La tarifa diaria debe ser mayor a cero.");
        }
        for (BookLoan loan : loans) {
            if (loan.getDaysOverdue() < 0) {
                throw new IllegalArgumentException("Los días de retraso no pueden ser valores negativos.");
            }
        }
    }
}