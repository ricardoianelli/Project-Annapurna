package edu.miu.userservice.dto.request;

import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import java.io.Serializable;

/**
 * @author bijayshrestha on 6/12/22
 * @project cs544-project
 */
@Data
public class RoleRequestDTO implements Serializable {
    private String name;
    private boolean status = true;
}
