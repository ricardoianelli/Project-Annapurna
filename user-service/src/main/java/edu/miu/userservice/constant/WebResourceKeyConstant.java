package edu.miu.userservice.constant;

public class WebResourceKeyConstant {

    public static final String API_V1 = "/api/v1";
    public static final String ALL = "/all";
    public static final String SUBSCRIBED = "subscribed";


    public interface UserConstants {
        String USER_BASE = "/users";
        String USER_ID = "/{id}";
        String FETCH_USER_BY_USERNAME = "/username/{username}";
        String SEARCH = "/search";

    }

    public interface RoleConstants {
        String ROLE_BASE = "/roles";
        String ROLE_ID = "/{id}";
        String ROLES = "/roles";
        String USERNAME_AND_ROLE_ID = "/username/{username}/roles/{roleId}";
        String ROLES_SUCCESSFULLY_CREATED ="Role removed successfully";
    }
}