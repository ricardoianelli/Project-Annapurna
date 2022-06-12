package edu.miu.emailservice.facade.impl;

import edu.miu.emailservice.dto.UserResponseDTO;
import edu.miu.emailservice.facade.EmailServicesFacade;
import edu.miu.emailservice.services.DailyMealFetchService;
import edu.miu.emailservice.services.EmailCreatorService;
import edu.miu.emailservice.services.EmailSenderService;
import edu.miu.emailservice.services.SubscribersService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailServicesFacadeImpl implements EmailServicesFacade {
    final DailyMealFetchService dailyMealFetchService;
    final EmailCreatorService emailCreatorService;
    final EmailSenderService emailSenderService;
    final SubscribersService subscribersService;

    public EmailServicesFacadeImpl(DailyMealFetchService dailyMealFetchService, EmailCreatorService emailCreatorService, EmailSenderService emailSenderService, SubscribersService subscribersService) {
        this.dailyMealFetchService = dailyMealFetchService;
        this.emailCreatorService = emailCreatorService;
        this.emailSenderService = emailSenderService;
        this.subscribersService = subscribersService;
    }

    @Override
    public void sendEmailToSubscribers() {
        List<UserResponseDTO> subscribers = subscribersService.getSubscribersList();
        System.out.println("Test");
    }
}
