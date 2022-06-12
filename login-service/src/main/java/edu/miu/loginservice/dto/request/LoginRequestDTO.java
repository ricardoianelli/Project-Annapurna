package edu.miu.loginservice.dto.request;

import lombok.*;

import java.io.Serializable;

/**
 * @author bijayshrestha on 6/10/22
 * @project cs544-project
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequestDTO implements Serializable {
    private String userCredential;
    private String password;
}
