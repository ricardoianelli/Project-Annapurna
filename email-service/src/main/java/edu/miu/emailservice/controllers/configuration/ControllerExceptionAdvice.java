package edu.miu.emailservice.controllers.configuration;

import edu.miu.emailservice.exceptions.NoDailyMealsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ControllerExceptionAdvice {
    @ExceptionHandler(NoDailyMealsException.class)
    public ResponseEntity<StandardError> handleUsersNotFound(NoDailyMealsException ex, HttpServletRequest request) {
        String errorMsg = ex.getMessage();
        HttpStatus status = HttpStatus.FAILED_DEPENDENCY;
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
