package edu.miu.userservice.utils;

import edu.miu.userservice.dto.request.UserRequestDTO;
import edu.miu.userservice.dto.response.UserResponseDTO;
import edu.miu.userservice.dto.response.UserResponseFeignDTO;
import edu.miu.userservice.model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class UserUtils {

    public static List<UserResponseDTO> parseUserToUserResponseDTO(List<User> users){
        List<UserResponseDTO> userResponseDTOList = new ArrayList<>();
        for (User user : users) {
            UserResponseDTO userResponseDTO = new UserResponseDTO();
            userResponseDTO.setId(user.getId());
            userResponseDTO.setName(user.getName());
            userResponseDTO.setEmail(user.getEmail());
            userResponseDTO.setUsername(user.getUsername());
            userResponseDTO.setPassword(user.getPassword());
            userResponseDTO.setSubscribed(user.getSubscribed());
            userResponseDTO.setRoles(user.getRoles());
            userResponseDTOList.add(userResponseDTO);
        }
        return userResponseDTOList;
    }

    //TODO: THIS NEEDS TO BE REFACTORED
    public static User parseUserRequestDTOToUser(User user, UserRequestDTO userRequestDTO){
        user.setName(userRequestDTO.getName());
        user.setUsername(userRequestDTO.getUsername());
        user.setEmail(userRequestDTO.getEmail());
        user.setSubscribed(userRequestDTO.getSubscribed());
        return user;
    }

    public static UserResponseDTO parseUserRequestDTOToUserResponseDTO(UserRequestDTO userRequestDTO, Long id){
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setId(id);
        userResponseDTO.setName(userRequestDTO.getName());
        userResponseDTO.setEmail(userRequestDTO.getEmail());
        userResponseDTO.setSubscribed(userRequestDTO.getSubscribed());
        return userResponseDTO;
    }

    public static UserResponseDTO parseUserToUserResponseDTO(User user){
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setId(user.getId());
        userResponseDTO.setName(user.getName());
        userResponseDTO.setUsername(user.getUsername());
        userResponseDTO.setPassword(user.getPassword());
        userResponseDTO.setEmail(user.getEmail());
        userResponseDTO.setSubscribed(user.getSubscribed());
        userResponseDTO.setRoles(user.getRoles());
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

    public static Function<User, UserResponseFeignDTO> convertToUserResponseFeignDTO = user -> {
        UserResponseFeignDTO userResponseFeignDTO = new UserResponseFeignDTO();

        userResponseFeignDTO.setId(user.getId());
        userResponseFeignDTO.setPassword(user.getPassword());
        userResponseFeignDTO.setUsername(user.getUsername());
        userResponseFeignDTO.setEmail(user.getEmail());
        userResponseFeignDTO.setName(user.getName());
        userResponseFeignDTO.setSubscribed(user.getSubscribed());
        userResponseFeignDTO.setRoles(user.getRoles());

        return userResponseFeignDTO;
    };
}
