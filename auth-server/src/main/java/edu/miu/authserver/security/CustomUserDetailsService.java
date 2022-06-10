package edu.miu.authserver.security;

import edu.miu.authserver.dto.response.UserResponseFeignDTO;
import edu.miu.authserver.feignClient.UserFeignInterface;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    private UserFeignInterface userFeignInterface;

    public CustomUserDetailsService(UserFeignInterface userFeignInterface) {
        this.userFeignInterface = userFeignInterface;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserResponseFeignDTO userResponseFeignDTO = userFeignInterface.fetchUserByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username:" + username + " not found"));

        List<GrantedAuthority> grantedAuthorities = userResponseFeignDTO.getRoles()
                .stream().map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

        return new User(String.join("-", username, userResponseFeignDTO.getEmail()),
                userResponseFeignDTO.getPassword(), true, true, true,
                true, grantedAuthorities);
    }
}
