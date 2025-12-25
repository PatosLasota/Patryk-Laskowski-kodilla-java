package com.kodilla.good.patterns.challenges.food2door.producer;

import com.kodilla.good.patterns.challenges.food2door.order.OrderRequest;
import com.kodilla.good.patterns.challenges.food2door.order.OrderResult;

public interface FoodProducer {
    String getName();

    OrderResult process(OrderRequest orderRequest);
}
