package edu.miu.userservice.utils;

import edu.miu.userservice.dto.request.UserRequestDTO;
import edu.miu.userservice.dto.response.UserResponseDTO;
import edu.miu.userservice.dto.response.UserResponseFeignDTO;
import edu.miu.userservice.model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class UserUtils {
    public static List<UserResponseDTO> parseUserToUserResponseDTO(List<User> users){
        List<UserResponseDTO> userResponseDTOList = new ArrayList<>();
        for (User user :
                users) {
            UserResponseDTO userResponseDTO = new UserResponseDTO();
            userResponseDTO.setId(user.getId());
            userResponseDTO.setName(user.getName());
            userResponseDTO.setEmail(user.getEmail());
            userResponseDTO.setSubscribed(user.getSubscribed());
            userResponseDTOList.add(userResponseDTO);
        }
        return userResponseDTOList;
    }

    public static User parseUserRequestDTOToUser(UserRequestDTO userRequestDTO){
        User user = new User();
        user.setName(userRequestDTO.getName());
        user.setEmail(userRequestDTO.getEmail());
        user.setSubscribed(userRequestDTO.getSubscribed());
        switch(userRequestDTO.getRoleType()) {
            case 'B':
                user.setRoles(Arrays.asList("FACULTY", "STUDENT"));
                break;
            case 'F':
                user.setRoles(Arrays.asList("FACULTY"));
                break;
            default:
                user.setRoles(Arrays.asList("STUDENT"));
        }

        return user;
    }

    public static UserResponseDTO parseUserRequestDTOToUserResponseDTO(UserRequestDTO userRequestDTO){
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setName(userRequestDTO.getName());
        userResponseDTO.setEmail(userRequestDTO.getEmail());
        userResponseDTO.setSubscribed(userRequestDTO.getSubscribed());
        return userResponseDTO;
    }

    public static UserResponseDTO parseUserToUserResponseDTO(User user){
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setId(user.getId());
        userResponseDTO.setName(user.getName());
        userResponseDTO.setEmail(user.getEmail());
        userResponseDTO.setSubscribed(user.getSubscribed());

        return userResponseDTO;
    }

    public static UserResponseFeignDTO parseUserToUserResponseFeignDTO(User user){
        UserResponseFeignDTO userResponseDTO = new UserResponseFeignDTO();
        userResponseDTO.setId(user.getId());
        userResponseDTO.setUsername(user.getUsername());
        userResponseDTO.setPassword(user.getPassword());
        userResponseDTO.setName(user.getName());
        userResponseDTO.setEmail(user.getEmail());
        userResponseDTO.setSubscribed(user.getSubscribed());
        userResponseDTO.setRoles(user.getRoles());

        return userResponseDTO;
    }

}
