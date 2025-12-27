package com.kodilla.spring.intro.shape;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DrawerTestSuite {

    @Test
    void testDoDrawingWithCircle(){

        Circle circle = new Circle();

        Drawer drawer = new Drawer(circle);
        String result = drawer.doDrawing();

        assertEquals("This is a circle figure", result);
    }

    @Test
    void testDoDrawingWithTriangle(){

        Triangle triangle = new Triangle();

        Drawer drawer = new Drawer(triangle);
        String result = drawer.doDrawing();

        assertEquals("This is a triangle figure", result);
    }
}
