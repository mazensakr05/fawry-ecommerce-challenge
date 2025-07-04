package model;

import java.time.LocalDate;

public class ExpirableProduct extends Product implements Expirable {
    // The date after which the product is considered expired
    private LocalDate expiryDate;

    // Constructor to create an expirable product with name, price, quantity, and expiry date
    public ExpirableProduct(String name, double price, int quantity, LocalDate expiryDate) {
        super(name, price, quantity);
        this.expiryDate = expiryDate;
    }

    // Check if the product is expired based on today's date
    @Override
    public boolean isExpired() {
        return LocalDate.now().isAfter(expiryDate);
    }

    // Get the expiry date of the product
    public LocalDate getExpiryDate() {
        return expiryDate;
    }
}
