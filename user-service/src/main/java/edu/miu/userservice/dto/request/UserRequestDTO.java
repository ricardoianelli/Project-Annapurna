package edu.miu.userservice.dto.request;

import lombok.Data;

import java.io.Serializable;
import java.util.List;


@Data
public class UserRequestDTO implements Serializable {
    private String name;
    private String username;
    private String password;
    private String email;
    private Boolean subscribed;
    private List<String> roles;
}
