package service;

import model.Shippable;
import java.util.List;
import java.util.Map;
import java.util.HashMap;


public class SimpleShippingService implements ShippingService {

    @Override
    public void ship(List<Shippable> items) {
        System.out.println("** Shipment notice **");
        
        // Count quantities of each product by name
        Map<String, Integer> counts = new HashMap<>();
        double totalWeight = 0;

        for (Shippable item : items) {
            counts.put(item.getName(), counts.getOrDefault(item.getName(), 0) + 1);
            totalWeight += item.getWeight();
        }

        // Print each item and its quantity
        counts.forEach((name, qty) -> System.out.printf("%dx %s\n", qty, name));

        // Print total weight in kg rounded to one decimal
        System.out.printf("Total package weight %.1fkg\n", totalWeight / 1000.0);
    }
}
