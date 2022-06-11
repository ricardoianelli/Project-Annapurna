package edu.miu.loginservice.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

/**
 * @author bijayshrestha on 6/10/22
 * @project cs544-project
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse implements Serializable {

    private String errorMsg;

    private String developerMsg;

    private HttpStatus responseStatus;

    private int responseCode;
}
