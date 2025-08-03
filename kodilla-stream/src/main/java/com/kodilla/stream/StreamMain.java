package com.kodilla.stream;

import com.kodilla.stream.beautifier.PoemBeautifier;

public class StreamMain {

    public static void main(String[] args) {
        PoemBeautifier poemBeautifier = new PoemBeautifier();

        poemBeautifier.beautify("Hello World", text -> "ABC" + text + "ABC");

        poemBeautifier.beautify("Hello World", String::toUpperCase);

        poemBeautifier.beautify("Hello World", text -> new StringBuilder(text).reverse().toString());

        poemBeautifier.beautify("Hello World", text -> text.replace(" ", "?"));

    }
}