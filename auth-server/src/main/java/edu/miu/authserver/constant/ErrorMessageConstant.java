package edu.miu.authserver.constant;

/**
 * @author bijayshrestha on 6/10/22
 * @project cs544-project
 */
public class ErrorMessageConstant {
    public interface TokenInvalid {
        String DEVELOPER_MESSAGE= "Request not authorized.";
        String MESSAGE ="Unmatched JWT token.";
    }
}
