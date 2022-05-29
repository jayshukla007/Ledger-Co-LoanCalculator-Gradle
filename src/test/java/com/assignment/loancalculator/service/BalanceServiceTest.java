package com.assignment.loancalculator.service;

import com.assignment.loancalculator.domain.Bank;
import com.assignment.loancalculator.domain.Borrower;
import com.assignment.loancalculator.domain.Loan;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class BalanceServiceTest {

    @Test
    public void shouldDisplayBalance() {
        List<Bank> banksWithLoan = new ArrayList<>();
        Loan loan = new Loan(5000, 1, 6, new Borrower("John"));
        Bank bank = new Bank("IDIDI", Arrays.asList(loan));
        banksWithLoan.add(bank);

        BalanceService balanceService = new BalanceService();
        String balance = balanceService.displayBalance("IDIDI", "John", 4, banksWithLoan);

        Assertions.assertEquals("IDIDI John 1768 8", balance);

    }

    @Test
    public void shouldDisplayUpdatedBalanceAfterLumpSumPayment() {
        List<Bank> banksWithLoan = new ArrayList<>();
        Loan loan = new Loan(5000, 1, 6, new Borrower("John"));
        loan.lumpSumAmountPaid().put(5, 1000);
        Bank bank = new Bank("IDIDI", Arrays.asList(loan));
        banksWithLoan.add(bank);


        BalanceService balanceService = new BalanceService();
        String balance = balanceService.displayBalance("IDIDI", "John", 6, banksWithLoan);


        Assertions.assertEquals("IDIDI John 3652 4", balance);
    }

}