package com.kodilla.testing.shape;

import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {

    private List<Shape> shapes = new ArrayList<>();


    void addFigure(Shape shape){
        //dodaje figure do kolekcji
    }
    boolean removeFigure(Shape shape){
        return false; //usuwa figure z kolekcji narazie jest false
    }
    public static Shape getFigure(int n){
        return null; // Zwraca figure z kolekcji narazie nic nie zwraca
    }

    public String showFigures(){
        return null; //zrwaca wszyskie nazwy figur jako jeden String, narazie nie zwraca nic
    }

}
