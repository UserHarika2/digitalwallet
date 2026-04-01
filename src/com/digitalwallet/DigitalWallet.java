package com.digitalwallet;

public class DigitalWallet {
    private final String userId;
    private double balance;

    // Constructor
    public DigitalWallet(String userId, double initialBalance) {
        this.userId = userId;
        this.balance = initialBalance;
    }

    // Get Balance
    public double getBalance() {
        return balance;
    }

    // Deposit Money
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        balance += amount;
    }

    // Withdraw Money
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient balance");
        }
        balance -= amount;
    }

    // Transfer Money
    public void transfer(DigitalWallet receiver, double amount) {
        if (receiver == null) {
            throw new IllegalArgumentException("Receiver cannot be null");
        }
        this.withdraw(amount);
        receiver.deposit(amount);
    }

    // Display Wallet Info
    public void printDetails() {
        System.out.println("User: " + userId + ", Balance: ₹" + balance);
    }
}
