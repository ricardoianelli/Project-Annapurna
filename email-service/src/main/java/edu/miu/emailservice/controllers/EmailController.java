package edu.miu.emailservice.controllers;

import edu.miu.emailservice.facade.EmailServicesFacade;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static edu.miu.emailservice.constant.WebResourceKeyConstant.API_V1;
import static edu.miu.emailservice.constant.WebResourceKeyConstant.UserConstants.EMAIL_BASE;

@RestController
@RequestMapping(value = API_V1 + EMAIL_BASE)
@Api(value = "Email Resource to handle all email related action and queries ")
public class EmailController {
    final EmailServicesFacade emailServicesFacade;

    public EmailController(EmailServicesFacade emailServicesFacade) {
        this.emailServicesFacade = emailServicesFacade;
    }

    @PostMapping("/send")
    @ApiOperation(value = "Sends Email to all the subscribed users.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Email Sent Successfully"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "Requested Resource Not Found")
    })
    public ResponseEntity<?> sendEmails(){
        emailServicesFacade.sendEmailToSubscribers();
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
