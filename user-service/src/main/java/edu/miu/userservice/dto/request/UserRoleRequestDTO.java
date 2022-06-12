package edu.miu.userservice.dto.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @author bijayshrestha on 6/12/22
 * @project cs544-project
 */
@Data
public class UserRoleRequestDTO implements Serializable {
    private String username;
    private String roleName;
}
