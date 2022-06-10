package edu.miu.userservice.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import edu.miu.userservice.exception.InputFieldEmptyException;
import edu.miu.userservice.exception.UserNotFoundException;

@ControllerAdvice
public class ControllerExceptionAdvice {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<String> handleUsersNotFound(UserNotFoundException userNotFound) {
        return new ResponseEntity<String>("No User Found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InputFieldEmptyException.class)
    public ResponseEntity<String> handleInputFieldEntity(InputFieldEmptyException inputFieldEmpty) {
        return new ResponseEntity<>("Input Field is Empty", HttpStatus.BAD_REQUEST);
    }
}
