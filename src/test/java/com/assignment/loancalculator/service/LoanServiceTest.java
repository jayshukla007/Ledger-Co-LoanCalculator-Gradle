package com.assignment.loancalculator.service;

import com.assignment.loancalculator.domain.Bank;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class LoanServiceTest {

    @Test
    public void shouldProcessLoan() {
        List<Bank> banksWithLoan = new ArrayList<>();
        LoanService loanService = new LoanService();

        loanService.processLoan("IDIDI", "Dale", 5000, 1, 6, banksWithLoan);

        Assertions.assertEquals(1, banksWithLoan.size());
        Assertions.assertEquals("IDIDI", banksWithLoan.get(0).getName());
        Assertions.assertEquals(5000, banksWithLoan.get(0).getLoans().get(0).getPrincipalLoanAmount());
        Assertions.assertEquals(1, banksWithLoan.get(0).getLoans().get(0).getTenure());
        Assertions.assertEquals(6, banksWithLoan.get(0).getLoans().get(0).getInterestRate());
    }

}