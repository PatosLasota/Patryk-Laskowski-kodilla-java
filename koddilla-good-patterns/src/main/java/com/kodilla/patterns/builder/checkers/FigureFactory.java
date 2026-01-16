package com.kodilla.patterns.builder.checkers;

public final class FigureFactory {
    public static final String PAWN = "PAWN";
    public static final String QUEEN = "QUEEN";

    public static Figure makeFigure(String figureTupe, String color) {
        if (figureTupe.equals(PAWN)) {
            return new Pawn(color);
        }  else if (figureTupe.equals(QUEEN)) {
            return new Queen(color);
        } else {
            throw new IllegalStateException("Type of figure should be Pawn or Queen");
        }
    }
}
