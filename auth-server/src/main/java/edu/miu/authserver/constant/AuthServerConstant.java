package edu.miu.authserver.constant;

/**
 * @author bijayshrestha on 6/10/22
 * @project cs544-project
 */
public class AuthServerConstant {
    public static final String LOGIN_SERVICE_FULL_URL = "/login-service/api/v1/login";

    public static final String USER_SERVICE = "user-service";

    public interface UserServiceConstant {
        String GET_USER_BY_USERNAME = "/api/v1/users/username/{username}";
    }
}
