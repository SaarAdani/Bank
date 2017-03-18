package com.Files.Infrasructure;


public class Accounts {

    private String owner;
    private int number;
    private int balance;
    public static int counter;

    public Accounts(String owner) {

        this.owner = owner;
        number = ++counter;

    }

    public String getOwner() {
        return owner;
    }

    public int getNumber() {
        return number;
    }

    public int getBalance() {
        return balance;
    }

    public void Deposit(int sum) {
        this.balance += sum;
    }
}
