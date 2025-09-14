package com.kodilla.stream.array;

import java.util.stream.IntStream;

public interface ArrayOperations {
    static double getAverage(int[] numbers){
        IntStream.range(0, numbers.length)
                .forEach(index -> System.out.print(numbers[index]));
        return IntStream.range(0, numbers.length)
                .map(index -> numbers[index])
                .average()
                .orElse(0.0);
    }

}
