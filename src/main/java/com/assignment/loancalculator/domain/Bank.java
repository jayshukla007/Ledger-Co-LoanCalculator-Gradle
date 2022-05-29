package com.assignment.loancalculator.domain;

import java.util.List;

public class Bank {
    String name;
    List<Loan> loans;

    public Bank(String name) {
        this.name = name;
    }

    public Bank(String name, List<Loan> loans) {
        this.name = name;
        this.loans = loans;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Loan> getLoans() {
        return loans;
    }

    public void takeLoan(Loan loan) {
        this.loans.add(loan);
    }
}
