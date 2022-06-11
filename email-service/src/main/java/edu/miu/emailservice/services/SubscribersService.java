package edu.miu.emailservice.services;

import edu.miu.emailservice.domain.User;

import java.util.List;

public interface SubscribersService {
    List<User> getSubscribersList();
}
