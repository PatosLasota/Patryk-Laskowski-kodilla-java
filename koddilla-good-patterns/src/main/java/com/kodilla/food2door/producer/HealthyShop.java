package com.kodilla.food2door.producer;

import com.kodilla.food2door.order.OrderRequest;
import com.kodilla.food2door.order.OrderResult;

public class HealthyShop implements FoodProducer {

    @Override
    public String getName() {
        return "Healthy Shop";
    }

    @Override
    public OrderResult process(OrderRequest orderRequest) {
        System.out.println("HealthyShop realizuje zamówienie hurtowe: "
                + orderRequest.getProductName());
        if (orderRequest.getQuantity() < 10) {
            return new OrderResult(
                    false,
                    "Zamówienie jest zbyt małe. Minimalna ilość to 10"
            );
        } else {
            return new OrderResult(
                    true,
                    "Zamówienie przyjęte przez Healthy Shop"
            );
        }
    }

}
