package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;
import com.kodilla.stream.iterate.NumbersGenerator;

public class StreamMain {

    public static void main(String[] args) {
        PoemBeautifier poemBeautifier = new PoemBeautifier();

        poemBeautifier.beautify("Hello World", text -> "ABC" + text + "ABC");

        poemBeautifier.beautify("Good Morning!", String::toUpperCase);

        poemBeautifier.beautify("Nice to meet you.", text -> new StringBuilder(text).reverse().toString());

        poemBeautifier.beautify("Have a great day!", text -> text.replace(" ", "?"));


        System.out.println("Using Stream to generate even numbers from 1 to 20");
        NumbersGenerator.generateEven(20);
    }
}