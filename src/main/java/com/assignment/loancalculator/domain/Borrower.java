package com.assignment.loancalculator.domain;

import java.math.BigDecimal;

public class Borrower {
    String name;

    public Borrower(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
