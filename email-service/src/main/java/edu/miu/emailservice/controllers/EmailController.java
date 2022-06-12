package edu.miu.emailservice.controllers;

import edu.miu.emailservice.facade.EmailServicesFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static edu.miu.emailservice.constant.WebResourceKeyConstant.API_V1;
import static edu.miu.emailservice.constant.WebResourceKeyConstant.UserConstants.EMAIL_BASE;

@RestController
@RequestMapping(value = API_V1 + EMAIL_BASE)
public class EmailController {
    final EmailServicesFacade emailServicesFacade;

    public EmailController(EmailServicesFacade emailServicesFacade) {
        this.emailServicesFacade = emailServicesFacade;
    }

    @PostMapping("/send")
    public ResponseEntity<?> sendEmails(){
        emailServicesFacade.sendEmailToSubscribers();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
