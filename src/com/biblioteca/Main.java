package com.biblioteca;

import com.biblioteca.domain.BookLoan;
import com.biblioteca.service.LibraryFineService;
import com.biblioteca.strategy.PenaltyStrategy;
import com.biblioteca.strategy.RegularPenaltyStrategy;
import com.biblioteca.strategy.StudentPenaltyStrategy;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Inicialización de datos simulados
        List<BookLoan> prestamosTardios = new ArrayList<>();
        prestamosTardios.add(new BookLoan("Cien años de soledad", 4)); 
        prestamosTardios.add(new BookLoan("Álgebra de Baldor", 2));    
        
        double tarifaDiaria = 2.50; // Costo por día de retraso

        System.out.println("SISTEMA DE CONTROL DE PENALIZACIONES DE BIBLIOTECA");

        // Escenario A: Cálculo inyectando estrategia de Estudiante
        PenaltyStrategy estrategiaEstudiante = new StudentPenaltyStrategy();
        LibraryFineService servicioEstudiantes = new LibraryFineService(estrategiaEstudiante);
        double multaEstudiante = servicioEstudiantes.calculateTotalFine(prestamosTardios, tarifaDiaria);
        System.out.println("-> Ejecución con perfil ESTUDIANTE (50% desc.): " + multaEstudiante);

        // Escenario B: Cálculo inyectando estrategia Regular
        PenaltyStrategy estrategiaRegular = new RegularPenaltyStrategy();
        LibraryFineService servicioRegulares = new LibraryFineService(estrategiaRegular);
        double multaRegular = servicioRegulares.calculateTotalFine(prestamosTardios, tarifaDiaria);
        System.out.println("-> Ejecución con perfil REGULAR (Sin desc.):     " + multaRegular);
        System.out.println("=================================================");
    }
}