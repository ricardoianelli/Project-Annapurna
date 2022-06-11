package edu.miu.emailservice.services;

import edu.miu.emailservice.domain.Email;

public interface EmailSenderService {
    void send(Email email);
}
