//package edu.miu.apigatewayone.feignClient;
//
//import edu.miu.apigatewayone.constant.MicroServiceConstant;
//import edu.miu.apigatewayone.dto.request.UserRequestFeignDTO;
//import edu.miu.apigatewayone.dto.response.UserResponseFeignDTO;
//import edu.miu.apigatewayone.model.User;
//import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.stereotype.Service;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import static edu.miu.apigatewayone.constant.MicroServiceConstant.UserServiceConstants.USER_SERVICE;
//
///**
// * @author bijayshrestha on 6/11/22
// * @project cs544-project
// */
//@FeignClient(name = USER_SERVICE)
//@Service
//public interface UserFeignInterface {
//
//    @RequestMapping(value = MicroServiceConstant.UserServiceConstants.GET_USER_BY_USERNAME)
//    UserResponseFeignDTO findUserByUsername(@PathVariable String username);
//}
