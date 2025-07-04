package service;

import model.Shippable;
import java.util.List;

public interface ShippingService {
    void ship(List<Shippable> items);
}
