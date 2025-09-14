package com.kodilla.stream.array;

import com.kodilla.stream.array.ArrayOperations;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ArrayOperationsTestSuite {

    @Test
    void testGetAverage(){
        //Given
        int[] numbers = new int[20];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }
        //When
        double average = ArrayOperations.getAverage(numbers);
        //Then
        Assertions.assertEquals(10.5, average, 0.001);
    }
}
