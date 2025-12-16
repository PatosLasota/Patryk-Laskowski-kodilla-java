package com.kodilla.good.patterns.challenges;

public class Application {
    public static void main(String[] args) {
        InformationService informationService = new EmailInformationService();
        OrderService orderService = new SimpleOrderService();
        OrderRepository orderRepository = new OrderRepositoryImpl();

        ProductOrderService productOrderService = new ProductOrderService(
                informationService,
                orderService,
                orderRepository);

        User user = new User("Grzegosz", "Brzęczyszczykiewicz@wp.pl");
        Product product = new Product("Kalesony", 123);
        OrderRequest orderRequest = new OrderRequest(user, product);

        OrderDto orderDto = ProductOrderService.process(orderRequest);

        System.out.println("Czy zamówienie zostało złożone: " + orderDto.isOrdered());
    }
}