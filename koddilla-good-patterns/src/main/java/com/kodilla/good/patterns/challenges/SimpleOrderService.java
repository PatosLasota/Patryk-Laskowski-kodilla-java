package com.kodilla.good.patterns.challenges;

public class SimpleOrderService implements OrderService {
    @Override
    public boolean createOrder(User user, Product product) {
        System.out.println("Creating order of: " + product.getName() + "for" + user.getName());
        return true;
    }
}
