package com.Files.Infrastructures;


public class Accounts {

    private String name;
    private int accountNumber;
    private int balance;
    private static int counter;
    private boolean minus;

    public Accounts (String name) {

        this.name = name;
        accountNumber = ++counter;
    }

    public Accounts (String name, int accountNumber, int balance) {

        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
        ++counter;
    }

    public String getName() {
        return name;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public int getBalance() {
        return balance;
    }

    public boolean isMinus() {
        return minus;
    }

    public void DepositBalance(int balance) {
        this.balance += balance;
    }

    public boolean WithdrawalBalance(int balance) {
        int number = this.balance - balance;
        if (number < 0) {
            minus = true;
            return minus;
        }
        else{
            this.balance -= balance;
        }
        minus = false;
        return minus;
    }
}
