package com.assignment.loancalculator.domain;

import java.util.HashMap;
import java.util.Map;

public class Loan {
    Integer principalLoanAmount;
    Integer tenure;
    Integer interestRate;
    Borrower borrower;
    Integer emi;
    Map<Integer, Integer> lumpSumAmountPaid = new HashMap<>();

    public Loan(Integer principalLoanAmount, Integer tenure, Integer interestRate, Borrower borrower) {
        this.principalLoanAmount = principalLoanAmount;
        this.tenure = tenure;
        this.interestRate = interestRate;
        this.borrower = borrower;
    }

    public Integer getPrincipalLoanAmount() {
        return principalLoanAmount;
    }

    public void setPrincipalLoanAmount(Integer principalLoanAmount) {
        this.principalLoanAmount = principalLoanAmount;
    }

    public Integer getTenure() {
        return tenure;
    }

    public void setTenure(Integer tenure) {
        this.tenure = tenure;
    }

    public Integer getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(Integer interestRate) {
        this.interestRate = interestRate;
    }

    public Borrower getBorrower() {
        return borrower;
    }

    public void setBorrower(Borrower borrower) {
        this.borrower = borrower;
    }

    public Integer getEmi() {
        return emi;
    }

    public void setEmi(Integer emi) {
        this.emi = emi;
    }

    public Map<Integer, Integer> lumpSumAmountPaid() {
        return lumpSumAmountPaid;
    }

    public Double totalAmountToBePaid(){
        Double interest = Double.valueOf(principalLoanAmount * tenure * interestRate/100);
        Double total = principalLoanAmount+interest;
        return principalLoanAmount+interest;
    }

    public Double calculateEmiAmount(){
        return Math.ceil(totalAmountToBePaid()/(tenure*12));
    }

}
