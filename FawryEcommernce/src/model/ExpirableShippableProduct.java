package model;

import java.time.LocalDate;

public class ExpirableShippableProduct extends ExpirableProduct implements Shippable {
    // Weight in grams
    private double weight;

    // Constructor with name, price, quantity, expiry date, and weight
    public ExpirableShippableProduct(String name, double price, int quantity, LocalDate expiryDate, double weight) {
        super(name, price, quantity, expiryDate);
        this.weight = weight;
    }

    // Return the product weight
    @Override
    public double getWeight() {
        return weight;
    }
}
