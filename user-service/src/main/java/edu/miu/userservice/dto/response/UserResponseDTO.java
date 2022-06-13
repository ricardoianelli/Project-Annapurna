package edu.miu.userservice.dto.response;

import edu.miu.userservice.model.Role;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
public class UserResponseDTO implements Serializable {
    private Long id;
    private String name;
    private String email;
    private String username;
    private String password;
    private Boolean subscribed;
    private Collection<Role> roles = new ArrayList<>();
}
