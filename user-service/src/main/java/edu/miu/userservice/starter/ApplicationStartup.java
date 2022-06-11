package edu.miu.userservice.starter;

import edu.miu.userservice.config.StartupProperties;
import edu.miu.userservice.model.User;
import edu.miu.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.Arrays;
import java.util.List;

/**
 * @author bijayshrestha on 6/11/22
 * @project cs544-project
 */
@Component
public class ApplicationStartup {

    @Autowired
    private StartupProperties startupProperties;

    @Bean
    public CommandLineRunner loadData(UserRepository userRepository) {
        return (args) -> {
            List<User> users = userRepository.findAll();

            if (ObjectUtils.isEmpty(users)) {
                userRepository.save(new User(
                        startupProperties.getUsername(),
                        BCrypt.hashpw(startupProperties.getPassword(), BCrypt.gensalt()),
                        startupProperties.getEmail(),
                        startupProperties.getSubscribed(),
                        startupProperties.getName(),
                        Arrays.asList("FACULTY", "STUDENT")));
            }
        };
    }
}
