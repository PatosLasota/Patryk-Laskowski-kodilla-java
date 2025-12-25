package com.kodilla.good.patterns.challenges.food2door.order;

public class OrderResult {
    private final boolean success;
    private final String message;

    public OrderResult(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
