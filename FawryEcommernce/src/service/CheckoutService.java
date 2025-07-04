package service;

import model.*;
import java.util.ArrayList;
import java.util.List;

public class CheckoutService {

    private ShippingService shippingService;

    public CheckoutService(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    public void checkout(Customer customer, Cart cart) throws Exception {
        if (cart.isEmpty()) {
            throw new Exception("Cart is empty.");
        }

        double subtotal = 0;
        double shippingFees = 0;
        List<Shippable> itemsToShip = new ArrayList<>();

        for (CartItem item : cart.getItems()) {
            Product product = item.getProduct();
            int quantity = item.getQuantity();

            // Check stock
            if (quantity > product.getQuantity()) {
                throw new Exception("Product " + product.getName() + " is out of stock.");
            }

            // Check expiration if applicable
            if (product instanceof Expirable) {
                if (((Expirable) product).isExpired()) {
                    throw new Exception("Product " + product.getName() + " is expired.");
                }
            }

            subtotal += product.getPrice() * quantity;

            // Collect shippable items
            if (product instanceof Shippable) {
                for (int i = 0; i < quantity; i++) {
                    itemsToShip.add((Shippable) product);
                }
                shippingFees += calculateShippingFee((Shippable) product, quantity);
            }
        }

        double totalAmount = subtotal + shippingFees;

        if (customer.getBalance() < totalAmount) {
            throw new Exception("Insufficient balance.");
        }

        // Deduct from customer balance
        customer.deductBalance(totalAmount);

        // Reduce product quantities
        for (CartItem item : cart.getItems()) {
            item.getProduct().reduceQuantity(item.getQuantity());
        }

        // Ship the items if any
        if (!itemsToShip.isEmpty()) {
            shippingService.ship(itemsToShip);
        }

        printReceipt(cart, subtotal, shippingFees, totalAmount, customer);
    }

    private double calculateShippingFee(Shippable product, int quantity) {
        // Example: 10 currency units per kg (1000 grams)
        double weightKg = product.getWeight() / 1000.0;
        return 10 * weightKg * quantity;
    }

    private void printReceipt(Cart cart, double subtotal, double shipping, double total, Customer customer) {
        System.out.println("** Checkout receipt **");
        
        for (CartItem item : cart.getItems()) {
            String name = item.getProduct().getName();
            int qty = item.getQuantity();
            double totalPrice = item.getProduct().getPrice() * qty;

            // Format: quantity x name ....... total price
            System.out.printf("%-25s %10.2f\n", qty + "x " + name, totalPrice);
        }

        System.out.println("----------------------------------------");
        System.out.printf("%-25s %10.2f\n", "Subtotal:", subtotal);
        System.out.printf("%-25s %10.2f\n", "Shipping:", shipping);
        System.out.printf("%-25s %10.2f\n", "Total:", total);
        System.out.printf("%-25s %10.2f\n", "Balance after payment:", customer.getBalance());
    }

}
