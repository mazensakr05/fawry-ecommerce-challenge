package model;

public class Customer {
    // Customer's name
    private String name;

    // Customer's current balance (money available)
    private double balance;

    // Constructor to create a customer with a name and starting balance
    public Customer(String name, double balance) {
        this.name = name;
        this.balance = balance;
    }

    // Get customer's name
    public String getName() {
        return name;
    }

    // Get customer's balance
    public double getBalance() {
        return balance;
    }

    // Deduct an amount from the customer's balance
    public void deductBalance(double amount) {
        this.balance -= amount;
    }
}
