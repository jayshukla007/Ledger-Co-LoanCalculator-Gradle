package com.assignment.loancalculator.service;

import com.assignment.loancalculator.domain.Bank;
import com.assignment.loancalculator.domain.Borrower;
import com.assignment.loancalculator.domain.Loan;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class PaymentServiceTest {


    @Test
    public void shouldProcessLumpSumPayment() {
        List<Bank> banksWithLoan = new ArrayList<>();
        Loan loan = new Loan(5000, 5, 4, new Borrower("John"));
        Bank bank = new Bank("IDIDI", Arrays.asList(loan));
        banksWithLoan.add(bank);

        PaymentService paymentService = new PaymentService();

        paymentService.processPayment("IDIDI", "John", 1000, 3, banksWithLoan);

        Assertions.assertEquals("IDIDI", banksWithLoan.get(0).getName());
        Assertions.assertEquals("John", banksWithLoan.get(0).getLoans().get(0).getBorrower().getName());
        Assertions.assertEquals(1000, banksWithLoan.get(0).getLoans().get(0).lumpSumAmountPaid().get(3));
    }

    @Test
    public void shouldNotProcessLumpSumPaymentBeforeGivenEMINumber() {
        List<Bank> banksWithLoan = new ArrayList<>();
        Loan loan = new Loan(5000, 5, 4, new Borrower("John"));
        Bank bank = new Bank("IDIDI", Arrays.asList(loan));
        banksWithLoan.add(bank);

        PaymentService paymentService = new PaymentService();

        paymentService.processPayment("IDIDI", "John", 1000, 3, banksWithLoan);

        Assertions.assertEquals("IDIDI", banksWithLoan.get(0).getName());
        Assertions.assertEquals("John", banksWithLoan.get(0).getLoans().get(0).getBorrower().getName());
        Assertions.assertEquals(null, banksWithLoan.get(0).getLoans().get(0).lumpSumAmountPaid().get(2));
    }

}