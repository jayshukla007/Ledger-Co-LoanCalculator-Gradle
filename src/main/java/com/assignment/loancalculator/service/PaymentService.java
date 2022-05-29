package com.assignment.loancalculator.service;

import com.assignment.loancalculator.domain.Bank;

import java.util.List;

public class PaymentService {

    public void processPayment(String bankName, String borrowerName, Integer lumpSum, Integer emiNo, List<Bank> banks) {
        banks.stream().forEach(b -> {
            if (b.getName().equalsIgnoreCase(bankName)) {
                b.getLoans().stream().forEach(l -> {
                    if (l.getBorrower().getName().equalsIgnoreCase(borrowerName)) {
                        l.lumpSumAmountPaid().put(emiNo, lumpSum);
                    }
                });
            }
        });
    }

}
