package edu.miu.loginservice.dto.response;

import edu.miu.loginservice.model.Role;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
    private String username;
    private String password;
    private String name;
    private String email;
    private Boolean subscribed;
    private Collection<Role> roles  = new ArrayList<>();
}
