package com.kodilla.stream.beautifier;

public class PoemBeautifier {

    public void beautify (String text, PoemDecorator poemDecorator) {
        if (text == null) {
            System.out.println("Warning: text is null");
            return;
        }
        if (poemDecorator == null) {
            System.out.println("Warning: poemDecorator is null");
            return;
        }

        String result = poemDecorator.decorate(text);
        System.out.println(result);
    }

}
