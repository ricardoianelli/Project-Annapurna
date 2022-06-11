package edu.miu.userservice.controller;

import edu.miu.userservice.dto.request.UserRequestDTO;
import edu.miu.userservice.dto.request.UserRequestFeignDTO;
import edu.miu.userservice.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static edu.miu.userservice.constant.WebResourceKeyConstant.API_V1;
import static edu.miu.userservice.constant.WebResourceKeyConstant.UserConstants.*;
import static org.springframework.http.ResponseEntity.ok;

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

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id){
        return new ResponseEntity<>(userService.getUserById(id),
                HttpStatus.OK);
    }

    @GetMapping(value = FETCH_USER_BY_USERNAME)
    public ResponseEntity<?> fetchAdminByUsername(@PathVariable("username") String username) {
        return ok(userService.getUserByUsername(username));
    }

    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody UserRequestDTO userRequestDTO){
        return new ResponseEntity<>(userService.addUser(userRequestDTO),
                HttpStatus.CREATED);
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody UserRequestDTO userRequestDTO){
        return new ResponseEntity<>(userService.updateUser(userRequestDTO, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id){
        return new ResponseEntity<>(userService.deleteUser(id), HttpStatus.OK);
    }

    @PostMapping(value = SEARCH)
    public ResponseEntity<?> searchUser(@RequestBody UserRequestFeignDTO requestDTO) {
        return ok().body(userService.searchUser(requestDTO));
    }
}
