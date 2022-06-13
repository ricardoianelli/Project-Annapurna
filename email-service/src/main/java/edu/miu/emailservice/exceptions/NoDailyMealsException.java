package edu.miu.emailservice.exceptions;

public class NoDailyMealsException extends RuntimeException {

    public NoDailyMealsException() {
    }

    public NoDailyMealsException(String message) {
        super(message);
    }
}
