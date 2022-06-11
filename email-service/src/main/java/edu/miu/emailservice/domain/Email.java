package edu.miu.emailservice.domain;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.stream.Collectors;

public class Email {
    private final String subject = "Your daily dinning information is here!";
    @NotBlank
    private String from;
    @NotBlank
    private String to;
    private String bcc;
    @NotBlank
    private String body;

    public Email(String from, String to, String body) {
        this.from = from;
        this.to = to;
        this.body = body;
    }

    public Email(String from, String to, String body, List<String> bcc) {
        this.from = from;
        this.to = to;
        this.body = body;
        this.bcc = bcc.stream().collect(Collectors.joining(","));
    }
}
