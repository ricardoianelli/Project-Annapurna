package edu.miu.apigatewayone.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
