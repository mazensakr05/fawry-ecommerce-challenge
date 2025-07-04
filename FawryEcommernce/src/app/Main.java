package app;

import model.*;
import service.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Create products
        ExpirableShippableProduct cheese = new ExpirableShippableProduct("Cheese", 100, 5, LocalDate.now().plusDays(10), 400);
        ExpirableProduct biscuits = new ExpirableProduct("Biscuits", 150, 3, LocalDate.now().plusDays(5));
        ShippableProduct tv = new ShippableProduct("TV", 2000, 2, 70000);
        Product scratchCard = new Product("Mobile Scratch Card", 50, 10) {};

        // Customer with enough balance
        Customer customer1 = new Customer("Ahmed", 5000);

        // Customer with low balance
        Customer customer2 = new Customer("Mona", 100);

        // Customer with exact balance
        Customer customer3 = new Customer("Omar", 3108);

        // Create shipping and checkout service
        ShippingService shippingService = new SimpleShippingService();
        CheckoutService checkoutService = new CheckoutService(shippingService);

        System.out.println("=== Normal Checkout ===");
        Cart cart1 = new Cart();
        try {
            cart1.addProduct(cheese, 2);
            cart1.addProduct(biscuits, 1);
            cart1.addProduct(tv, 1);
            cart1.addProduct(scratchCard, 1);
            checkoutService.checkout(customer1, cart1);
        } catch (Exception e) {
            System.out.println("Checkout error: " + e.getMessage());
        }

        System.out.println("\n=== Expired Product Error ===");
        Cart cart2 = new Cart();
        ExpirableProduct expiredBiscuits = new ExpirableProduct("Expired Biscuits", 150, 1, LocalDate.now().minusDays(1));
        try {
            cart2.addProduct(expiredBiscuits, 1);
            checkoutService.checkout(customer1, cart2);
        } catch (Exception e) {
            System.out.println("Checkout error: " + e.getMessage());
        }

        System.out.println("\n=== Out of Stock Error ===");
        Cart cart3 = new Cart();
        try {
            cart3.addProduct(tv, 3); // only 2 in stock
            checkoutService.checkout(customer1, cart3);
        } catch (Exception e) {
            System.out.println("Checkout error: " + e.getMessage());
        }

        System.out.println("\n=== Insufficient Balance Error ===");
        Cart cart4 = new Cart();
        try {
            cart4.addProduct(cheese, 2);
            cart4.addProduct(tv, 1);
            checkoutService.checkout(customer2, cart4); // customer2 balance is 100 only
        } catch (Exception e) {
            System.out.println("Checkout error: " + e.getMessage());
        }

        System.out.println("\n=== Adding Too Many Items To Cart Error ===");
        Cart cart5 = new Cart();
        try {
            cart5.addProduct(cheese, 10); // only 5 in stock
        } catch (IllegalArgumentException e) {
            System.out.println("Add to cart error: " + e.getMessage());
        }
    }
}
