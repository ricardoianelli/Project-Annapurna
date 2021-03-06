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
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

import static edu.miu.userservice.constant.ExceptionConstant.NOT_FOUND;
import static edu.miu.userservice.constant.ExceptionConstant.USER_NOT_FOUND_MESSAGE;
import static edu.miu.userservice.utils.UserUtils.convertToUserResponseFeignDTO;
import static edu.miu.userservice.utils.UserUtils.parseUserToUserResponseDTO;

@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;

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
            throw new UserNotFoundException(NOT_FOUND,USER_NOT_FOUND_MESSAGE );
        }
    }

    @Override
    public UserResponseFeignDTO getUserByUsername(String username) {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            return UserUtils.parseUserToUserResponseFeignDTO(user);
        } else {
            //TODO: IMPLEMENT EXCEPTION HANDLING HERE
            return new UserResponseFeignDTO();
        }
    }

    @Override
    public UserResponseDTO addUser(UserRequestDTO userRequestDTO) {
        //TODO: CHECK IF USER EXIST BY USERNAME, IF YES -> THROW ERROR
        User user = UserUtils.parseUserRequestDTOToUser(new User(), userRequestDTO);
        user.setPassword(passwordEncoder.encode(userRequestDTO.getPassword()));
        user = userRepository.save(user);
        return parseUserToUserResponseDTO(user);
    }

    @Override
    public UserResponseDTO updateUser(UserRequestDTO userRequestDTO, Long id) {
        User user = userRepository.findById(id).get();
        user = UserUtils.parseUserRequestDTOToUser(user, userRequestDTO);
        user.setId(id);
        if(userRequestDTO.getPassword()!= null || !userRequestDTO.getPassword().isEmpty()) {
            user.setPassword(passwordEncoder.encode(userRequestDTO.getPassword()));
        };
        userRepository.save(user);
        return parseUserToUserResponseDTO(user);
    }

    @Override
    public void deleteUser(Long id) throws Exception{
        User user = userRepository.findById(id)
                .orElseThrow(() -> new Exception("Throw Some Good Exception Here."));
        userRepository.delete(user);
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
        //TODO:EXCEPTION NEEDS TO BE HANDLED HERE
        return convertToUserResponseFeignDTO.apply(user);
    }

    @Override
    public void addUserRole(UserRoleRequestDTO userRoleRequestDTO) {
        //TODO:
        // EXCEPTION CAN BE HANDLED ON BOTH CASES BECAUSE WE CANNOT ASSIGN
        // ROLES THAT'S NOT DEFINED DURING STARTUP
        User user = userRepository.findByUsername(userRoleRequestDTO.getUsername());
        Role role = roleRepository.findByName(userRoleRequestDTO.getRoleName());
        user.getRoles().add(role);
    }

    @Override
    public void removeUserRole(String username, Long roleId) {
        //TODO: EXCEPTION CAN BE HANDLED ON BOTH CASES
        User user = userRepository.findByUsername(username);
        Role role = roleRepository.findById(roleId).get();
        user.getRoles().remove(role);
    }


}
