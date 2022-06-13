package edu.miu.userservice.dto.request;

import lombok.Data;

import java.io.Serializable;

/**
 * @author bijayshrestha on 6/12/22
 * @project cs544-project
 */
@Data
public class RoleRequestUpdateDTO implements Serializable {
    private String name;
    private boolean status;
}
