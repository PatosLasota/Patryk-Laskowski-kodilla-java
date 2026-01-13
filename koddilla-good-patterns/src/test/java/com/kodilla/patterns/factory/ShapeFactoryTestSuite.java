package com.kodilla.patterns.factory;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShapeFactoryTestSuite {
    @Test
    void testFactoryCircle(){
        ShapeFactory factory = new ShapeFactory();

        Shape circle = factory.makeShape(ShapeFactory.CIRCLE);

        assertEquals(Math.PI * Math.pow(4.5,2),circle.getArea());
        assertEquals("The rounded circle", circle.getName());
    }

    @Test
    void testFactorySquare(){
        ShapeFactory factory = new ShapeFactory();
        Shape square = factory.makeShape(ShapeFactory.SQUARE);
        assertEquals(28, square.getCircumference());
        assertEquals("The angular square", square.getName());
    }

    @Test
    void testFactoryRectangle(){
        ShapeFactory factory = new ShapeFactory();
        Shape rectangle = factory.makeShape(ShapeFactory.RECTANGLE);
        assertEquals(37.5, rectangle.getArea());
        assertEquals("The long rectangle", rectangle.getName());
    }
}
