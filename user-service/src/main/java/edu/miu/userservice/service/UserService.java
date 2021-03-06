package edu.miu.userservice.service;

import edu.miu.userservice.dto.request.UserRequestDTO;
import edu.miu.userservice.dto.request.UserRequestFeignDTO;
import edu.miu.userservice.dto.request.UserRoleRequestDTO;
import edu.miu.userservice.dto.response.UserResponseDTO;
import edu.miu.userservice.dto.response.UserResponseFeignDTO;

import java.util.List;

public interface UserService {

    List<UserResponseDTO> getAllUsers();

    UserResponseDTO getUserById(Long id);

    UserResponseFeignDTO getUserByUsername(String username);

    UserResponseDTO addUser(UserRequestDTO userRequestDTO);

    UserResponseDTO updateUser(UserRequestDTO userRequestDTO, Long id);

    void deleteUser(Long id) throws Exception;

    UserResponseFeignDTO searchUser(UserRequestFeignDTO requestDTO);

    List<UserResponseDTO> getUsersBySubscription(boolean subscribed);

    void addUserRole(UserRoleRequestDTO userRoleRequestDTO);

    void removeUserRole(String username, Long roleId);

}
