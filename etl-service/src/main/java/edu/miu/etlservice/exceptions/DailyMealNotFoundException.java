package edu.miu.etlservice.exceptions;

public class DailyMealNotFoundException extends RuntimeException {
    public DailyMealNotFoundException() {
    }

    public DailyMealNotFoundException(String message) {
        super(message);
    }
}
