package edu.miu.userservice.service.impl;

import edu.miu.userservice.dto.request.UserRequestDTO;
import edu.miu.userservice.dto.request.UserRequestFeignDTO;
import edu.miu.userservice.dto.request.UserRoleRequestDTO;
import edu.miu.userservice.dto.response.UserResponseDTO;
import edu.miu.userservice.dto.response.UserResponseFeignDTO;
import edu.miu.userservice.exception.UserNotFoundException;
import edu.miu.userservice.model.Role;
import edu.miu.userservice.model.User;
import edu.miu.userservice.repository.RoleRepository;
import edu.miu.userservice.repository.UserRepository;
import edu.miu.userservice.service.UserService;
import edu.miu.userservice.utils.UserUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

import static edu.miu.userservice.utils.UserUtils.convertToUserResponseFeignDTO;

@Service
@Transactional
// TODO: REFACTORING REQUIRED AFTER WE DONE WITH ALL THE POSITIVE AND NEGATIVE
// TESTING
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository,
            PasswordEncoder passwordEncoder, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
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
            return UserUtils.parseUserToUserResponseDTO(user);
        } catch (NoSuchElementException ex) {
            throw new UserNotFoundException();
        }
    }

    @Override
    public UserResponseFeignDTO getUserByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            return UserUtils.parseUserToUserResponseFeignDTO(user);
        } else {
            // TODO: IMPLEMENT EXCEPTION HANDLING HERE
            return new UserResponseFeignDTO();
        }
    }

    @Override
    public String addUser(UserRequestDTO userRequestDTO) {
        // TODO: CHECK IF USER EXIST BY USERNAME, IF YES -> THROW ERROR
        User user = UserUtils.parseUserRequestDTOToUser(userRequestDTO);
        user.setPassword(passwordEncoder.encode(userRequestDTO.getPassword()));
        user = userRepository.save(user);
        if (user != null) {
            // TODO: CHANGE RETURN TYPE TO VOID
            return "User Created Successfully!";
        } else {
            return "Sorry, something went wrong";
        }
    }

    @Override
    public UserResponseDTO updateUser(UserRequestDTO userRequestDTO, Long id) {
        User user = userRepository.findById(id).get();
        user = UserUtils.parseUserRequestDTOToUser(userRequestDTO);
        user.setId(id);
        user.setPassword(passwordEncoder.encode(userRequestDTO.getPassword()));
        userRepository.save(user);
        return UserUtils.parseUserRequestDTOToUserResponseDTO(userRequestDTO, id);
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

    @Override
    public UserResponseFeignDTO searchUser(UserRequestFeignDTO userRequestFeignDTO) {
        User user = null;
        if (userRequestFeignDTO.getEmailAddress() != null) {
            user = userRepository.findByEmail(userRequestFeignDTO.getEmailAddress()).get();
        } else {
            user = userRepository.findByUsername(userRequestFeignDTO.getUsername());
        }
        // TODO:EXCEPTION NEEDS TO BE HANDLED HERE
        return convertToUserResponseFeignDTO.apply(user);
    }

    @Override
    public void addUserRole(UserRoleRequestDTO userRoleRequestDTO) {
        // TODO: EXCEPTION CAN BE HANDLED ON BOTH CASES
        User user = userRepository.findByUsername(userRoleRequestDTO.getUsername());
        Role role = roleRepository.findByName(userRoleRequestDTO.getRoleName());
        user.getRoles().add(role);
    }

    @Override
    public void removeUserRole(String username, Long roleId) {
        // TODO: EXCEPTION CAN BE HANDLED ON BOTH CASES
        User user = userRepository.findByUsername(username);
        Role role = roleRepository.findById(roleId).get();
        user.getRoles().remove(role);
    }

}
