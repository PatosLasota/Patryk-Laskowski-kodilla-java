package com.kodilla.food2door.producer;

import com.kodilla.food2door.order.OrderRequest;
import com.kodilla.food2door.order.OrderResult;

public interface FoodProducer {
    String getName();

    OrderResult process(OrderRequest orderRequest);
}
