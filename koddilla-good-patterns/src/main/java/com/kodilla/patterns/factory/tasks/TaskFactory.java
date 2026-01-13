package com.kodilla.patterns.factory.tasks;

public final class TaskFactory {
    public static final String DRIVING = "DRIVING";
    public static final String PAINTING = "PAINTING";
    public static final String SHOPPING = "SHOPPING";

    public static Task makeTask(final String taskType){

        return switch (taskType){
            case DRIVING -> new DrivingTask("Trip to work","Office", "Car");
            case PAINTING -> new PaintingTask("Room painting", "Red", "Walls");
            case SHOPPING -> new ShoppingTask("Weekly shopping", "Milk", 69);
            default -> null;
        };
    };
}
