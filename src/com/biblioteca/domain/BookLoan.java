package com.biblioteca.domain;

public class BookLoan {
    private String bookTitle;
    private int daysOverdue;

    public BookLoan(String bookTitle, int daysOverdue) {
        this.bookTitle = bookTitle;
        this.daysOverdue = daysOverdue;
    }

    public int getDaysOverdue() { 
        return daysOverdue; 
    }

    public String getBookTitle() {
        return bookTitle;
    }
}