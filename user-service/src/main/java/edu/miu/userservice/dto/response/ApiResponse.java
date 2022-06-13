package edu.miu.userservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * @author bijayshrestha on 6/12/22
 * @project cs544-project
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse implements Serializable {
    private Boolean success;
    private String message;
    private HttpStatus httpStatus;
}
