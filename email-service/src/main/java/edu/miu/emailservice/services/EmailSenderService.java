package edu.miu.emailservice.services;

import edu.miu.emailservice.domain.Email;

import java.util.List;

public interface EmailSenderService {
    void send(Email email);
    void sendBatch(Email email, List<String> emailList);
}
