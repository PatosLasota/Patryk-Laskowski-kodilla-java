package com.kodilla.testing.collection;

import org.junit.jupiter.api.*;

import java.util.Arrays;
import java.util.List;

public class CollectionTestSuite {
    @BeforeEach
    public void beforeEach() {
        System.out.println("Rozpoczynam test...");
    }

    @AfterEach
    public void afterEach() {
        System.out.println("Zakończyłem test.\n");
    }

    @Test
    @DisplayName("Test gdy lista wejściowa jest pusta")
    void testOddNumbersExterminatorEmptyList() {
        // Given
        OddNumbersExterminator exterminator = new OddNumbersExterminator();
        List<Integer> emptyList = Arrays.asList();

        // When
        List<Integer> result = exterminator.exterminate(emptyList);

        // Then
        Assertions.assertTrue(result.isEmpty());

    }

    @Test
    @DisplayName("Test dla listy zawierającej liczby parzyste i nieparzyste")
    void testOddNumbersExterminatorNormalList() {
        // Given
        OddNumbersExterminator exterminator = new OddNumbersExterminator();
        List<Integer> inputList = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> expectedResult = Arrays.asList(2, 4, 6);

        // When
        List<Integer> result = exterminator.exterminate(inputList);

        // Then
        Assertions.assertEquals(expectedResult, result);
    }
}
