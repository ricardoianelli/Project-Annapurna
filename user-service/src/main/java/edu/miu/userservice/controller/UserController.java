package edu.miu.userservice.controller;

import edu.miu.userservice.dto.request.UserRequestDTO;
import edu.miu.userservice.dto.request.UserRequestFeignDTO;
import edu.miu.userservice.dto.request.UserRoleRequestDTO;
import edu.miu.userservice.dto.response.ApiResponse;
import edu.miu.userservice.dto.response.UserResponseDTO;
import edu.miu.userservice.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

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
    public ResponseEntity<?> getUsers(@RequestParam Map<String,String> requestParams) {

        List<UserResponseDTO> users;

        if (requestParams.containsKey("subscribed")) {
            Boolean subscribed = Boolean.valueOf(requestParams.get("subscribed"));
            users = userService.getUsersBySubscription(subscribed);
        }
        else {
            users = userService.getAllUsers();
        }

        if (users.size() > 0) {
            return new ResponseEntity<>(users, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        return new ResponseEntity<>(userService.getUserById(id),
                HttpStatus.OK);
    }

    @GetMapping(value = FETCH_USER_BY_USERNAME)
    public ResponseEntity<?> fetchUserByUsername(@PathVariable("username") String username) {
        return ok(userService.getUserByUsername(username));
    }

    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody UserRequestDTO userRequestDTO) {
        return new ResponseEntity<>(userService.addUser(userRequestDTO),
                HttpStatus.CREATED);
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody UserRequestDTO userRequestDTO) {
        return new ResponseEntity<>(userService.updateUser(userRequestDTO, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        return new ResponseEntity<>(userService.deleteUser(id), HttpStatus.OK);
    }

    @PostMapping(value = SEARCH)
    public ResponseEntity<?> searchUser(@RequestBody UserRequestFeignDTO requestDTO) {
        return ok().body(userService.searchUser(requestDTO));
    }

    @PostMapping("/roles")
    public ResponseEntity<?> addUserRole(@RequestBody UserRoleRequestDTO userRoleRequestDTO){
        userService.addUserRole(userRoleRequestDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/username/{username}/roles/{roleId}")
    public ResponseEntity<ApiResponse> removeUserRole(@PathVariable String username, @PathVariable Long roleId){
        userService.removeUserRole(username, roleId);
        ApiResponse apiResponse = new ApiResponse(
                Boolean.TRUE,
                "Role removed successfully",
                HttpStatus.OK);
        return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
    }
}
