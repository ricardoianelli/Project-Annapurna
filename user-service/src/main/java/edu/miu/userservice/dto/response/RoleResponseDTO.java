package edu.miu.userservice.dto.response;

import lombok.Data;

import java.io.Serializable;

/**
 * @author bijayshrestha on 6/12/22
 * @project cs544-project
 */
@Data
public class RoleResponseDTO implements Serializable {
    private Long id;
    private String name;
    private boolean status;
}
