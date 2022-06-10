package edu.miu.userservice.utils;

import edu.miu.userservice.dto.request.UserRequestDTO;
import edu.miu.userservice.dto.response.UserResponseDTO;
import edu.miu.userservice.model.User;

import java.util.ArrayList;
import java.util.List;


public class UserUtils {
    public static List<UserResponseDTO> parseUserToUserResponseDTO(List<User> users){
        List<UserResponseDTO> userResponseDTOList = new ArrayList<>();
        for (User user :
                users) {
            UserResponseDTO userResponseDTO = new UserResponseDTO();
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
        return user;
    }

    public static UserResponseDTO parseUserRequestDTOToUserResponseDTO(UserRequestDTO userRequestDTO){
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setName(userRequestDTO.getName());
        userResponseDTO.setEmail(userRequestDTO.getEmail());
        userResponseDTO.setSubscribed(userRequestDTO.getSubscribed());
        return userResponseDTO;
    }

    public static UserResponseDTO parseUserToUserResponseDTOObject(User user){
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setName(user.getName());
        userResponseDTO.setEmail(user.getEmail());
        userResponseDTO.setSubscribed(user.getSubscribed());

        return userResponseDTO;
    }

}
