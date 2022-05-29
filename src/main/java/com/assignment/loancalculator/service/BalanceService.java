package com.assignment.loancalculator.service;

import com.assignment.loancalculator.domain.Bank;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class BalanceService {

    public String displayBalance(String bankName, String borrowerName, Integer emiNo, List<Bank> banks) {
        AtomicInteger amountPaid = new AtomicInteger();
        StringBuilder balance = new StringBuilder();
        banks.stream().forEach(b -> {
            if (b.getName().equalsIgnoreCase(bankName)) {
                b.getLoans().stream().forEach(l -> {
                    if (l.getBorrower().getName().equalsIgnoreCase(borrowerName)) {
                        Integer emiAmount = l.calculateEmiAmount().intValue();
                        l.setEmi(emiAmount);
                        Double totalAmountToBePaid = l.totalAmountToBePaid();
                        IntStream.rangeClosed(1, emiNo).forEach(e -> {
                            if (l.lumpSumAmountPaid().containsKey(e)) {
                                Integer remainingAmount = l.getPrincipalLoanAmount() - l.lumpSumAmountPaid().get(e);
                                l.setPrincipalLoanAmount(remainingAmount);
                                amountPaid.getAndAdd(l.lumpSumAmountPaid().get(e) + emiAmount);
                            } else {
                                amountPaid.getAndAdd(emiAmount);
                            }
                        });
                        Integer numberOfRemainingEmi = (int) Math.ceil((totalAmountToBePaid - amountPaid.get()) / emiAmount);
                        balance.append(b.getName() + " " + l.getBorrower().getName() + " " + amountPaid + " " + numberOfRemainingEmi);
                    }
                });
            }
        });
        return balance.toString();
    }
}
