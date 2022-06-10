package edu.miu.loginservice.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author bijayshrestha on 6/10/22
 * @project cs544-project
 */
@Getter
@Setter
public class LoginRequestDTO implements Serializable {
    private String userCredential;

    private String password;
}
