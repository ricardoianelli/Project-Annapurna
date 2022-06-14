package edu.miu.userservice.dto.response;

import edu.miu.userservice.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author bijayshrestha on 6/10/22
 * @project cs544-project
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseFeignDTO implements Serializable {
    private Long id;
    private String username;
    private String name;
    private String email;
    private Boolean subscribed;
    private Collection<Role> roles  = new ArrayList<>();
}
