package model;

public class CartItem {
    // The product added to the cart
    private Product product;

    // The quantity of the product in the cart
    private int quantity;

    // Constructor to create a cart item with product and quantity
    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    // Get the product
    public Product getProduct() {
        return product;
    }

    // Get the quantity of the product
    public int getQuantity() {
        return quantity;
    }
}
