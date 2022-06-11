package edu.miu.loginservice.constant;

/**
 * @author bijayshrestha on 6/10/22
 * @project cs544-project
 */
public class ErrorMessageConstant {
    public interface InvalidAdminUsername {
        String DEVELOPER_MESSAGE = "User entity returned null";
        String MESSAGE = "User with given username doesn't exits.";
    }

    public interface ForgetPassword {
        String DEVELOPER_MESSAGE = "Password didn't match with the original one.";
        String MESSAGE = "Incorrect password.Forgot Password?";
    }
}
