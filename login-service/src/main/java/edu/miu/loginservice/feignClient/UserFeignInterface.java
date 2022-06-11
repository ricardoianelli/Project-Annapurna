package edu.miu.loginservice.feignClient;

import edu.miu.loginservice.constant.MicroServiceConstant;
import edu.miu.loginservice.dto.request.UserRequestFeignDTO;
import edu.miu.loginservice.dto.response.UserResponseFeignDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import static edu.miu.loginservice.constant.MicroServiceConstant.UserServiceConstants.USER_SERVICE;

/**
 * @author bijayshrestha on 6/10/22
 * @project cs544-project
 */
@FeignClient(name = USER_SERVICE)
@Service
public interface UserFeignInterface {

    @RequestMapping(value = MicroServiceConstant.UserServiceConstants.SEARCH_USER)
    UserResponseFeignDTO searchUser(@RequestBody UserRequestFeignDTO userRequestFeignDTO);
}
