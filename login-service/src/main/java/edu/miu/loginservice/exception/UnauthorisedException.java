package edu.miu.loginservice.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

/**
 * @author bijayshrestha on 6/10/22
 * @project cs544-project
 */
@Getter
@Setter
public class UnauthorisedException extends RuntimeException {
    private ErrorResponse errorResponse;

    public UnauthorisedException(String message, String developerMessage) {
        super(message);
        errorResponse = new ErrorResponse();

        errorResponse.setDeveloperMsg(developerMessage);
        errorResponse.setErrorMsg(message);
        errorResponse.setResponseCode(HttpStatus.UNAUTHORIZED.value());
        errorResponse.setResponseStatus(HttpStatus.UNAUTHORIZED);
    }
}
