package com.assignment.loancalculator.service;

import com.assignment.loancalculator.domain.Bank;
import com.assignment.loancalculator.domain.Borrower;
import com.assignment.loancalculator.domain.Loan;

import java.util.ArrayList;
import java.util.List;

public class LoanService {

    public void processLoan(String bankName, String borrowerName, Integer principalAmount, Integer tenure,
                            Integer interestRate, List<Bank> banks) {
        Borrower borrower = new Borrower(borrowerName);
        Loan loan = new Loan(principalAmount, tenure, interestRate, borrower);
        Bank loanBank = new Bank(bankName, new ArrayList<>());
        loanBank.takeLoan(loan);
        banks.add(loanBank);
    }
}
