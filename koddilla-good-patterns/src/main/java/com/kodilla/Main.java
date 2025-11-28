package com.kodilla;

import com.kodilla.good.patterns.challenges.Factorial;
import com.kodilla.good.patterns.challenges.MovieStore;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        MovieStore movieStore = new MovieStore();

        String result = movieStore.getMovies().values().stream()
                .flatMap(List::stream)
                .collect(Collectors.joining("!"));

        System.out.println(result);

        Factorial factorial = new Factorial();

        System.out.println(factorial.calculateFactorial(4));
    }
}