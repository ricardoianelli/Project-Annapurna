package edu.miu.userservice.controller;

import edu.miu.userservice.dto.request.UserRequestDTO;
import edu.miu.userservice.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static edu.miu.userservice.constant.WebResourceKeyConstant.ALL;
import static edu.miu.userservice.constant.WebResourceKeyConstant.API_V1;
import static edu.miu.userservice.constant.WebResourceKeyConstant.UserConstants.USER_BASE;

@RestController
@RequestMapping(value = API_V1 + USER_BASE)
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<?> getUsers(){
        return new ResponseEntity<>(userService.getAllUsers(),
                HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addStudents(@RequestBody UserRequestDTO userRequestDTO){
        return new ResponseEntity<>(userService.addUser(userRequestDTO),
                HttpStatus.CREATED);
    }
}
