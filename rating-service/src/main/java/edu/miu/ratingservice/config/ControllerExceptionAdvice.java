package edu.miu.ratingservice.config;

import edu.miu.ratingservice.exception.MealNotFoundException;
import edu.miu.ratingservice.exception.RatingNotFound;
import edu.miu.ratingservice.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import edu.miu.ratingservice.controller.StandardError;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionAdvice {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<StandardError> handleUsersNotFound(UserNotFoundException ex, HttpServletRequest request) {
        String errorMsg = "User not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        return getResponseError(errorMsg, status, request);
    }

    @ExceptionHandler(MealNotFoundException.class)
    public ResponseEntity<StandardError> handleUsersNotFound(MealNotFoundException ex, HttpServletRequest request) {
        String errorMsg = "Meal Type not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        return getResponseError(errorMsg, status, request);
    }

    @ExceptionHandler(RatingNotFound.class)
    public ResponseEntity<StandardError> handleUsersNotFound(RatingNotFound ex, HttpServletRequest request) {
        String errorMsg = "Rating not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        return getResponseError(errorMsg, status, request);
    }

    private ResponseEntity<StandardError> getResponseError(String message, HttpStatus status,
            HttpServletRequest request) {
        StandardError error = new StandardError(Instant.now(), status.value(), message, null, request.getRequestURI());
        return ResponseEntity.status(status).body(error);
    }

    private ResponseEntity<StandardError> getResponseError(String message, HttpStatus status,
            HttpServletRequest request, Exception ex) {
        StandardError error = new StandardError(Instant.now(), status.value(), message, ex.getMessage(),
                request.getRequestURI());
        return ResponseEntity.status(status).body(error);
    }

}
