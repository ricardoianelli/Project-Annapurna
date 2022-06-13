package edu.miu.etlservice.controller.configuration;

import edu.miu.etlservice.exceptions.DailyMealNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionAdvice {
    @ExceptionHandler(DailyMealNotFoundException.class)
    public ResponseEntity<StandardError> noMealInformationFound(DailyMealNotFoundException ex, HttpServletRequest request) {
        String errorMsg = "Daily Meal not found";
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
