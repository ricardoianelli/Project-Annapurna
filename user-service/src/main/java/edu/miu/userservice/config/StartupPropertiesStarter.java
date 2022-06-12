package edu.miu.userservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * @author bijayshrestha on 6/11/22
 * @project cs544-project
 */
@Configuration
@PropertySource("classpath:startup.properties")
public class StartupPropertiesStarter {
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
