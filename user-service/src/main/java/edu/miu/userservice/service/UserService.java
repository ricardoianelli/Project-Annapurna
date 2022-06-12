package edu.miu.userservice.service;

import edu.miu.userservice.dto.request.UserRequestDTO;
import edu.miu.userservice.dto.response.UserResponseDTO;
import edu.miu.userservice.model.User;

import java.util.List;

public interface UserService {

    List<UserResponseDTO> getAllUsers();

    UserResponseDTO getUserById(Long id);

    String addUser(UserRequestDTO userRequestDTO);

    UserResponseDTO updateUser(UserRequestDTO userRequestDTO, Long id);

    String deleteUser(Long id);

    List<UserResponseDTO> getUsersBySubscription(boolean subscribed);
}
