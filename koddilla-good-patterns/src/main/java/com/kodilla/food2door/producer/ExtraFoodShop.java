package com.kodilla.food2door.producer;

import com.kodilla.food2door.order.OrderProcessor;
import com.kodilla.food2door.order.OrderRequest;
import com.kodilla.food2door.order.OrderResult;

public class ExtraFoodShop implements FoodProducer {

    @Override
    public String getName() {
        return "ExtraFoodShop";
    }

    @Override
    public OrderResult process(OrderRequest orderRequest) {
        System.out.println("ExtraFoodShop realizuje zamówienie hurtowe: "
                + orderRequest.getProductName());
        return new OrderResult(
                true,
                "Zamówienie przyjęte przez ExtraFoodShop"
        );
    }
}
