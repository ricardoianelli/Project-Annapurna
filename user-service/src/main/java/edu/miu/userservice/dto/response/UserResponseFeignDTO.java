package edu.miu.userservice.dto.response;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author bijayshrestha on 6/10/22
 * @project cs544-project
 */
@Data
public class UserResponseFeignDTO implements Serializable {
    private Long id;
    private String username;
    private String password;
    private String name;
    private String email;
    private Boolean subscribed;
    private List<String> roles  = new ArrayList<>();
}
