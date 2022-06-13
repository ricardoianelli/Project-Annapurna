package edu.miu.emailservice.services;

import edu.miu.emailservice.dto.UserResponseDTO;

import java.util.List;

public interface SubscribersService {
    List<UserResponseDTO> getSubscribersList();
}
