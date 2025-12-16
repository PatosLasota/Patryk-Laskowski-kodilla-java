package com.kodilla.good.patterns.challenges;

public class OrderRepositoryImpl implements OrderRepository {
    @Override
    public void createOrder(User user, Product product) {
        System.out.println("Saving order to the database.");
    }
}
