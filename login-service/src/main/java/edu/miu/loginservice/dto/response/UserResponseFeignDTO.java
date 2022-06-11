package edu.miu.loginservice.dto.response;

import lombok.*;

import java.io.Serializable;

/**
 * @author bijayshrestha on 6/10/22
 * @project cs544-project
 */

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseFeignDTO implements Serializable {
    private Long id;
    private String password;
    private String email;
}
