package edu.miu.userservice.service.impl;

import edu.miu.userservice.dto.request.UserRequestDTO;
import edu.miu.userservice.dto.response.UserResponseDTO;
import edu.miu.userservice.exception.InputFieldEmptyException;
import edu.miu.userservice.exception.UserNotFoundException;
import edu.miu.userservice.model.User;
import edu.miu.userservice.repository.UserRepository;
import edu.miu.userservice.service.UserService;
import edu.miu.userservice.utils.UserUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
// TODO: REFACTORING REQUIRED AFTER WE DONE WITH ALL THE POSITIVE AND NEGATIVE
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return UserUtils.parseUserToUserResponseDTO(users);
    }

    @Override
    public UserResponseDTO getUserById(Long id) throws UserNotFoundException {
        try {
            User user = userRepository.findById(id).get();
            return UserUtils.parseUserToUserResponseDTOObject(user);
        } catch (NoSuchElementException ex) {
            throw new UserNotFoundException();
        }
    }

    @Override
    public String addUser(UserRequestDTO userRequestDTO) {
        User user = UserUtils.parseUserRequestDTOToUser(userRequestDTO);
        if (user.getName().isEmpty() || user.getEmail().isEmpty() || user.getSubscribed() == null) {
            throw new InputFieldEmptyException();
        } else {
            user = userRepository.save(user);
            return "User Created Successfully!";
        }
        // user = userRepository.save(user);
        // if (user != null) {
        // // TODO: CHANGE RETURN TYPE TO VOID
        // return "User Created Successfully!";
        // } else {
        // return "Sorry, something went wrong";
        // }
    }

    @Override
    public UserResponseDTO updateUser(UserRequestDTO userRequestDTO, Long id) {
        try {
            User user = userRepository.findById(id).get();
            user = UserUtils.parseUserRequestDTOToUser(userRequestDTO);
            user.setId(id);
            userRepository.save(user);
            return UserUtils.parseUserRequestDTOToUserResponseDTO(userRequestDTO);
        } catch (NoSuchElementException ex) {
            throw new UserNotFoundException();
        }
        // User user = userRepository.findById(id).get();
        // if (user != null) {
        // user = UserUtils.parseUserRequestDTOToUser(userRequestDTO);
        // user.setId(id);
        // userRepository.save(user);
        // } else {
        // // TODO: NEED TO DO EXCEPTION HANDLING
        // return new UserResponseDTO();
        // }
        // return UserUtils.parseUserRequestDTOToUserResponseDTO(userRequestDTO);
    }

    @Override
    public String deleteUser(Long id) {
        try {
            User user = userRepository.findById(id).get();
            userRepository.delete(user);
            return "User Deleted Successfully!";
        } catch (NoSuchElementException ex) {
            throw new UserNotFoundException();
        }
    }

    @Override
    public List<UserResponseDTO> getUsersBySubscription(boolean subscribed) {
        List<User> users = userRepository.findBySubscribed(subscribed);
        return UserUtils.parseUserToUserResponseDTO(users);
    }
}
