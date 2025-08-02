package com.kodilla.testing.shape;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("ShapeCollector Test Suite")
public class ShapeCollectorTestSuite {

    private ShapeCollector collector;

    @BeforeEach
    public void setup() {
        collector = new ShapeCollector();
    }

    @Nested
    @DisplayName("Tests for adding and removing figures")
    class AddRemoveTests {
        @Test
        @DisplayName("Add figure to the collection")
        void testAddFigure() {
            //Given
            Shape square = new Square(5);
            //When
            collector.addFigure(square);
            //Then
            assertEquals(square, collector.getFigure(0));
        }

        @Test
        @DisplayName("Remove figure from the collection")
        void testRemoveFigure() {
            //Given
            Shape circle = new Circle(5);
            collector.addFigure(circle);
            //When
            boolean result = collector.removeFigure(circle);
            //Then
            assertTrue(result);
            assertEquals(0, collector.showFigures().length());
        }

        @Test
        @DisplayName("Try remove none existent Figure")
        void testRomoveNoneexistentFigure() {
            //Given
            Shape triangle = new Triangle(3.0, 4.0);
            //When
            boolean result = collector.removeFigure(triangle);
            //Then
            assertFalse(result);

        }

    }

    @Nested
    @DisplayName("Test for retrieving and showing figures")
    class RetrievelTests {

        @Test
        @DisplayName("Retrieve figure at given index")
        void testGetFigure() {
            //Given
            Shape triangle = new Triangle(3.0, 4.0);
            collector.addFigure(triangle);
            //When
            Shape result = collector.getFigure(0);
            //Then
            assertEquals(triangle, result);
        }
        @Test
        @DisplayName("Show all figures in collector in sinngle string")
        void testShowFigures() {
            //Given
            collector.addFigure(new Square(2.0));
            collector.addFigure(new Circle(2.0));
            collector.addFigure(new Triangle(2.0, 2.0));
            //When
            String result = collector.showFigures();
            //Then
            assertEquals("Square, Circle, Triangle", result);
        }
    }
}
