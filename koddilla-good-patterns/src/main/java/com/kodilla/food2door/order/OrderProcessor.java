package com.kodilla.food2door.order;

import com.kodilla.food2door.producer.FoodProducer;

public class OrderProcessor {
    public OrderResult process(FoodProducer producer, OrderRequest request) {
        System.out.println("Rozpopczęcie zamówienia u producenta: "
                + producer.getName());

        OrderResult result = producer.process(request);

        System.out.println("Wynik zamówienia: "
                + result.getMessage());

        return result;
    }
}
