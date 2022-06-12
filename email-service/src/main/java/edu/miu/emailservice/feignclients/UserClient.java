package edu.miu.emailservice.feignclients;

import edu.miu.emailservice.dto.UserResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient(name="user-service")
@Service
public interface UserClient {
    @GetMapping("/api/v1/users")
    List<UserResponseDTO> getUsers(@RequestHeader(value = "Authorization", required = true) String authorizationHeader, @RequestParam Map<String,String> requestParams);
}
