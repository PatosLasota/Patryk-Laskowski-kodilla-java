package com.kodilla.exception.test;

public class ExceptionHandling {

    public static void main(String[] args) {
        SecondChallenge challenge = new SecondChallenge();

        try {
            String result = challenge.probablyIWillThrowException(1.5, 1.0);
            System.out.println(result);
        } catch (Exception e) {
            System.out.println("An exception has occurred!");
        } finally {
            System.out.println("Execution finished (finally block always runs).");
        }
    }
}