package edu.miu.apigatewayone.dto.request;

import lombok.*;

import java.io.Serializable;

/**
 * @author bijayshrestha on 6/10/22
 * @project cs544-project
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequestFeignDTO implements Serializable {
    private String username;
    private String emailAddress;
}
