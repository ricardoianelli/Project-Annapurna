package edu.miu.userservice.dto.request;

import lombok.Data;

import java.io.Serializable;


@Data
public class UserRequestDTO implements Serializable {
    private String name;
    private String email;
    private Boolean subscribed;
}
