package edu.miu.ratingservice.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import edu.miu.ratingservice.dto.response.UserResponseDTO;

@FeignClient(name = "user-service")
@Service
public interface UserClient {
    @GetMapping("/api/v1/users/{id}")
    UserResponseDTO getUserById(@PathVariable Long id);
}
