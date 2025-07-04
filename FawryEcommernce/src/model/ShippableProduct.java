package model;

public class ShippableProduct extends Product implements Shippable {
    // Weight of the product 
    private double weight;

    // Constructor to create a shippable product with name, price, quantity, and weight
    public ShippableProduct(String name, double price, int quantity, double weight) {
        super(name, price, quantity);
        this.weight = weight;
    }

    // Return the product weight
    @Override
    public double getWeight() {
        return weight;
    }
}
