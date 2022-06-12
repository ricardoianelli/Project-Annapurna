package edu.miu.loginservice.service.impl;

import edu.miu.loginservice.dto.request.UserRequestFeignDTO;
import edu.miu.loginservice.dto.response.UserResponseFeignDTO;
import edu.miu.loginservice.repository.UserRepository;
import edu.miu.loginservice.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author bijayshrestha on 6/12/22
 * @project cs544-project
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponseFeignDTO searchUser(UserRequestFeignDTO requestDTO) {
        return null;
    }
}
