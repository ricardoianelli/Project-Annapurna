package edu.miu.userservice.starter;

import edu.miu.userservice.config.StartupProperties;
import edu.miu.userservice.model.Role;
import edu.miu.userservice.model.User;
import edu.miu.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @author bijayshrestha on 6/11/22
 * @project cs544-project
 */
@Component
public class ApplicationStartup {

    @Autowired
    private StartupProperties startupProperties;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    public CommandLineRunner loadData(UserRepository userRepository) {
        return (args) -> {
            List<User> users = userRepository.findAll();
            Collection<Role> rolesList = new ArrayList<>();
            rolesList.add(new Role("FACULTY"));
            //TODO: This is weird here!
            System.out.println("Name : " + startupProperties.getName());
            if (ObjectUtils.isEmpty(users)) {
                userRepository.save(new User(
                        startupProperties.getUsername(),
                        passwordEncoder.encode(startupProperties.getPassword()),
                        "Benedict Cumberbatch",
                        startupProperties.getEmail(),
                        startupProperties.getSubscribed(),
                        rolesList
                ));
            }
        };
    }
}
