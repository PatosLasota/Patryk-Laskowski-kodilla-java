package com.kodilla.food2door;

import com.kodilla.food2door.order.OrderProcessor;
import com.kodilla.food2door.order.OrderRequest;
import com.kodilla.food2door.producer.ExtraFoodShop;
import com.kodilla.food2door.producer.FoodProducer;
import com.kodilla.food2door.producer.GlutenFreeShop;
import com.kodilla.food2door.producer.HealthyShop;

public class App {
    public static void main(String[] args) {

        OrderProcessor orderProcessor = new OrderProcessor();

        OrderRequest orderRequest = new OrderRequest("Keks", 5);

        FoodProducer extraFoodShop = new ExtraFoodShop();
        FoodProducer healthyShop = new HealthyShop();
        FoodProducer glutenFreeShop = new GlutenFreeShop();

        orderProcessor.process(extraFoodShop, orderRequest);
        orderProcessor.process(healthyShop, orderRequest);
        orderProcessor.process(glutenFreeShop, orderRequest);

    }
}
