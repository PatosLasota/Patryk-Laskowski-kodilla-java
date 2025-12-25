package com.kodilla.good.patterns.challenges.food2door.producer;

import com.kodilla.good.patterns.challenges.food2door.order.OrderRequest;
import com.kodilla.good.patterns.challenges.food2door.order.OrderResult;

public class GlutenFreeShop implements FoodProducer {

    @Override
    public String getName() {
        return "GlutenFreeShop";
    }

    @Override
    public OrderResult process(OrderRequest orderRequest) {
        System.out.println("GlutenFreeShop realizuje zamówienie hurtowe: "
                + orderRequest.getProductName());
        if (orderRequest.getQuantity() > 10) {
            return new OrderResult(false, "Brak wystarczjacej liczby towaru.");
        } else {
            return new OrderResult(
                    true,
                    "Zamówienie przyjęte przez GlutenFreeShop"
            );
        }
    }
}
