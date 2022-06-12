package edu.miu.loginservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * @author bijayshrestha on 6/10/22
 * @project cs544-project
 */
@Configuration
@PropertySource("classpath:security.properties")
public class ApplicationPropertiesConfiguration {
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}