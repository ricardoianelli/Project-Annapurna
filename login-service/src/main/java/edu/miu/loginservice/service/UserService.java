package edu.miu.loginservice.service;

import edu.miu.loginservice.dto.request.UserRequestFeignDTO;
import edu.miu.loginservice.dto.response.UserResponseFeignDTO;

/**
 * @author bijayshrestha on 6/12/22
 * @project cs544-project
 */
public interface UserService {

    UserResponseFeignDTO searchUser(UserRequestFeignDTO requestDTO);
}
