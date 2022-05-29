package com.assignment.loancalculator.processor;

import com.assignment.loancalculator.domain.Bank;
import com.assignment.loancalculator.extractor.Extractor;
import com.assignment.loancalculator.extractor.FileExtractor;
import com.assignment.loancalculator.service.BalanceService;
import com.assignment.loancalculator.service.LoanService;
import com.assignment.loancalculator.service.PaymentService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LoanProcessor {

    List<Bank> banks;

    public LoanProcessor() {
        this.banks = new ArrayList<>();
    }

    public static void main(String[] args) {
        String inputFileName = "D:\\temp\\input.txt";
        Extractor extractor = new FileExtractor();

        String extractedData = extractor.extract(inputFileName);
        List<String> commands = Arrays.asList(extractedData.split("\n"));

        LoanProcessor processor = new LoanProcessor();

        commands.stream().forEach(c -> {
            String[] data = c.split(" ");
            processor.executeCommand(data);
        });
    }

    void executeCommand(String[] data) {
        String command = data[0];
        switch (command) {
            case "LOAN":
                LoanService loanService = new LoanService();
                loanService.processLoan(data[1], data[2], Integer.parseInt(data[3]),
                        Integer.parseInt(data[4]), Integer.parseInt(data[5].trim()), banks);
                break;

            case "PAYMENT":
                PaymentService paymentService = new PaymentService();
                paymentService.processPayment(data[1], data[2], Integer.parseInt(data[3]),
                        Integer.parseInt(data[4].trim()), banks);
                break;

            case "BALANCE":
                BalanceService balanceService = new BalanceService();
                String balance = balanceService.displayBalance(data[1], data[2], Integer.parseInt(data[3].trim()), banks);
                System.out.println(balance);
                break;

            default:
                System.out.println("Not a valid command");
                break;
        }
    }
}
