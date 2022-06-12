package edu.miu.userservice.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author bijayshrestha on 6/11/22
 * @project cs544-project
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "user")
public class StartupProperties {

    private String username;

    private String password;

    private String email;

    private Boolean subscribed;

    private String name;


}

