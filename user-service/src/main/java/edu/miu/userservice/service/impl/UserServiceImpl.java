package edu.miu.userservice.service.impl;

import edu.miu.userservice.dto.request.UserRequestDTO;
import edu.miu.userservice.dto.response.UserResponseDTO;
import edu.miu.userservice.model.User;
import edu.miu.userservice.repository.UserRepository;
import edu.miu.userservice.service.UserService;
import edu.miu.userservice.utils.UserUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserResponseDTO> userResponseDTOS = UserUtils.parseUserToUserResponseDTO(users);
        return userResponseDTOS;
    }

    @Override
    public String addUser(UserRequestDTO userRequestDTO) {
        User user = UserUtils.parseUserRequestDTOToUser(userRequestDTO);
        user = userRepository.save(user);
        if(user!= null){
            return "User Created Successfully!";
        } else{
            return "Sorry, something went wrong";
        }
    }

    @Override
    public UserResponseDTO updateUser(UserRequestDTO userRequestDTO, Long id) {
        User user = userRepository.findById(id).get();
        if(user != null){
            user = UserUtils.parseUserRequestDTOToUser(userRequestDTO);
            userRepository.save(user);
        }else{
            //TODO: NEED TO DO EXCEPTION HANDLING
            return new UserResponseDTO();
        }
        return UserUtils.parseUserRequestDTOToUserResponseDTO(userRequestDTO);
    }

    @Override
    public String deleteUser(Long id) {
        User user = userRepository.findById(id).get();
        if(user != null){
            userRepository.delete(user);
            return "User Deleted Successfully!";
        }else{
            return "User Not Found. ";
        }
    }


}
