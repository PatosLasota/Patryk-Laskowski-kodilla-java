package com.kodilla.testing;

import com.kodilla.testing.calculator.Calculator;
import com.kodilla.testing.user.SimpleUser;

public class TestingMain {

    public static void main(String[] args) {
        SimpleUser simpleUser = new SimpleUser("theForumUser");

        String result = simpleUser.getUsername();

        if (result.equals("theForumUser")) {
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }

        Calculator calculator = new Calculator();

        int sum = calculator.add(1, 2);
        int difference = calculator.subtract(1, 2);

        if (sum == 3) {
            System.out.println("test OK");
        } else {
            System.out.println("Error!");
        }

        if (difference == -1) {
            System.out.println("test OK");
        }  else {
            System.out.println("Error!");
        }
    }
}