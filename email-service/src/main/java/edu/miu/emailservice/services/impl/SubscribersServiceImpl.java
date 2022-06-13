package edu.miu.emailservice.services.impl;

import edu.miu.emailservice.dto.UserResponseDTO;
import edu.miu.emailservice.feignclients.UserClient;
import edu.miu.emailservice.helpers.RequestHelper;
import edu.miu.emailservice.services.SubscribersService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Service
public class SubscribersServiceImpl implements SubscribersService {
    private final UserClient userClient;

    public SubscribersServiceImpl(UserClient userClient) {
        this.userClient = userClient;
    }

    @Override
    public List<UserResponseDTO> getSubscribersList() {
        String token = RequestHelper.getAuthenticationToken();
        Map<String,String> requestParams = new HashMap<>();
        requestParams.put("subscribed", Boolean.valueOf(true).toString());
        return userClient.getUsers(token, requestParams);
    }
}
