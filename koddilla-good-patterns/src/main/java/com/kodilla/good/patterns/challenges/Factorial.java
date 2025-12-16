package com.kodilla.good.patterns.challenges;

public class Factorial {
    public long calculateFactorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Liczba nie moze byc ujemna");
        }
        if (n <= 1) {
            return 1;
        }
        return n * calculateFactorial(n - 1);
    }
}
