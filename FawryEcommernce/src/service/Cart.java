package service;

import model.CartItem;
import model.Product;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    // List of items in the cart
    private List<CartItem> items;

    public Cart() {
        this.items = new ArrayList<>();
    }

    /**
     * Add a product with a specified quantity to the cart.
     * Quantity must not exceed product's available quantity.
     */
    public void addProduct(Product product, int quantity) throws IllegalArgumentException {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive.");
        }
        if (quantity > product.getQuantity()) {
            throw new IllegalArgumentException("Not enough quantity available.");
        }

        // Check if product already in cart; if yes, increase quantity
        for (CartItem item : items) {
            if (item.getProduct().equals(product)) {
                int newQuantity = item.getQuantity() + quantity;
                if (newQuantity > product.getQuantity()) {
                    throw new IllegalArgumentException("Not enough quantity available after adding.");
                }
                // Remove old item and add new with updated quantity
                items.remove(item);
                items.add(new CartItem(product, newQuantity));
                return;
            }
        }

        // If product not in cart, add new CartItem
        items.add(new CartItem(product, quantity));
    }

    /**
     * Get all items in the cart.
     */
    public List<CartItem> getItems() {
        return items;
    }

    /**
     * Check if the cart is empty.
     */
    public boolean isEmpty() {
        return items.isEmpty();
    }
}
