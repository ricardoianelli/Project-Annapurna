package edu.miu.userservice.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import edu.miu.userservice.exception.InputFieldEmpty;
import edu.miu.userservice.exception.UsersNotFound;

@ControllerAdvice("edu.miu.userservice")
public class ThisControllerAdvice {

    @ExceptionHandler(UsersNotFound.class)
    public ResponseEntity<String> handleUsersNotFound(UsersNotFound userNotFound) {
        return new ResponseEntity<String>("No User Found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InputFieldEmpty.class)
    public ResponseEntity<String> handleInputFieldEntity(InputFieldEmpty inputFieldEmpty) {
        return new ResponseEntity<>("Input Field is Empty", HttpStatus.BAD_REQUEST);
    }
}
