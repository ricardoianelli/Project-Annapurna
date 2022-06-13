package edu.miu.emailservice.services.impl;

import edu.miu.emailservice.dto.UserResponseDTO;
import edu.miu.emailservice.feignclients.UserClient;
import edu.miu.emailservice.services.SubscribersService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SubscribersServiceImpl implements SubscribersService {
    private final UserClient userClient;

    public SubscribersServiceImpl(UserClient userClient) {
        this.userClient = userClient;
    }

    @Override
    public List<UserResponseDTO> getSubscribersList() {
        Map<String,String> requestParams = new HashMap<>();
        requestParams.put("subscribed", Boolean.valueOf(true).toString());
        return userClient.getUsers(requestParams);
    }
}
