package com.kodilla.spring.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Calculator {

    @Autowired
    private Display display;

    public double add(double num1, double num2){
        double result = num1 + num2;
        display.displayValue(result);
        return result;
    }

    public double subtract(double num1, double num2){
        double result = num1 - num2;
        display.displayValue(result);
        return result;
    }

    public double multiply(double num1, double num2){
        double result = num1 * num2;
        display.displayValue(result);
        return result;
    }
    public double divide(double num1, double num2){
        double result = num1 / num2;
        display.displayValue(result);
        return result;
    }
}
