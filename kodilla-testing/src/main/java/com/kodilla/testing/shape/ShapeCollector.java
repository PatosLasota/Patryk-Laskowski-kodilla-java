package com.kodilla.testing.shape;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ShapeCollector {

    private List<Shape> shapes = new ArrayList<>();


    public void addFigure(Shape shape){
        shapes.add(shape);
    }
    public boolean removeFigure(Shape shape){
       return shapes.remove(shape);
    }
    public Shape getFigure(int n){
        if(n >= 0 && n < shapes.size()){
            return shapes.get(n);
        } else {
            return null;
        }
    }

    public String showFigures(){
        StringBuilder names = new StringBuilder(); // używamy StringBuildera do składania tekstu
        for (int i = 0; i < shapes.size(); i++) {
            names.append(shapes.get(i).getShapeName());
            if(i < shapes.size()-1){
                names.append(", ");
            }
        }
        return names.toString();
    }

}
