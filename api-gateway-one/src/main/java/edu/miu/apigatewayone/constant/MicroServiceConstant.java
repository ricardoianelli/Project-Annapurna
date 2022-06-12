package edu.miu.apigatewayone.constant;

/**
 * @author bijayshrestha on 6/10/22
 * @project cs544-project
 */
public class MicroServiceConstant {
    public static final String BASE_API = "/api/V1";

    public interface UserServiceConstants {
        String USER_SERVICE = "user-service";
        String SEARCH_USER = "api/v1/users/search";
        String GET_USER_BY_USERNAME = "api/v1/users/username/{username}";
    }
}
