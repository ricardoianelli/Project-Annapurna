package edu.miu.userservice.config;

import edu.miu.userservice.controller.StandardError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import edu.miu.userservice.exception.InputFieldEmptyException;
import edu.miu.userservice.exception.UserNotFoundException;

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

    @ExceptionHandler(InputFieldEmptyException.class)
    public ResponseEntity<StandardError> handleInputFieldEntity(InputFieldEmptyException ex,
            HttpServletRequest request) {
        String errorMsg = "Input Field is Empty";
        HttpStatus status = HttpStatus.BAD_REQUEST;
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
