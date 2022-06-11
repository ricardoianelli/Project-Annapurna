package edu.miu.authserver.feignClient;

import edu.miu.authserver.dto.response.UserResponseFeignDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import edu.miu.authserver.constant.AuthServerConstant.UserServiceConstant;

import java.util.Optional;

import static edu.miu.authserver.constant.AuthServerConstant.USER_SERVICE;

/**
 * @author bijayshrestha on 6/10/22
 * @project cs544-project
 */
@FeignClient(name = USER_SERVICE)
@Service
public interface UserFeignInterface {

    @GetMapping(value = UserServiceConstant.GET_USER_BY_USERNAME)
    Optional<UserResponseFeignDTO> fetchUserByUsername(@PathVariable("username") String username) ;
}
