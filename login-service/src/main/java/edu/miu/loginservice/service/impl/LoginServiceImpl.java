package edu.miu.loginservice.service.impl;

import com.netflix.discovery.converters.Auto;
import edu.miu.loginservice.constant.ErrorMessageConstant;
import edu.miu.loginservice.constant.PatternConstant;
import edu.miu.loginservice.dto.request.LoginRequestDTO;
import edu.miu.loginservice.dto.request.UserRequestFeignDTO;
import edu.miu.loginservice.dto.response.UserResponseFeignDTO;
import edu.miu.loginservice.exception.UnauthorisedException;
import edu.miu.loginservice.jwt.JwtTokenProvider;
import edu.miu.loginservice.model.User;
import edu.miu.loginservice.repository.UserRepository;
import edu.miu.loginservice.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author bijayshrestha on 6/10/22
 * @project cs544-project
 */
@Service
@Transactional
public class LoginServiceImpl implements LoginService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Autowired
    JwtTokenProvider jwtTokenProvider;

    @Autowired
    private UserRepository userRepository;


    @Override
    public String login(LoginRequestDTO requestDTO, HttpServletRequest request) {
        User user = fetchUserDetails.apply(requestDTO);

        validateUsername.accept(user);
        validatePassword.accept(requestDTO, user);

        //TODO: REMOVE THIS AFTER THE TESTING IS SUCCESSFUL
        String jwtToken = jwtTokenProvider.createToken(requestDTO.getUserCredential(), request);

        return jwtToken;
    }

    private final Function<LoginRequestDTO, User> fetchUserDetails = (loginRequestDTO) -> {

        Pattern pattern = Pattern.compile(PatternConstant.EmailConstant.EMAIL_PATTERN);
        Matcher m = pattern.matcher(loginRequestDTO.getUserCredential());
        boolean match = m.matches();
        if(!match){
            Optional<User> byUsername = userRepository.findByUsername(loginRequestDTO.getUserCredential());
            return byUsername.get();
        }else{
            Optional<User> byEmail = userRepository.findByEmail(loginRequestDTO.getUserCredential());
            return byEmail.get();
        }


    };

    private final Consumer<User> validateUsername = (user) -> {
        if (Objects.isNull(user))
            throw new UnauthorisedException(ErrorMessageConstant.InvalidAdminUsername.MESSAGE,
                    ErrorMessageConstant.InvalidAdminUsername.DEVELOPER_MESSAGE);
    };

    private final BiConsumer<LoginRequestDTO, User> validatePassword
            = (loginRequestDTO, user) -> {

        LOGGER.info(":::: ADMIN PASSWORD VALIDATION ::::");


        if (!BCrypt.checkpw(loginRequestDTO.getPassword(), user.getPassword())) {
            LOGGER.debug("INCORRECT PASSWORD...");
            throw new UnauthorisedException(
                    ErrorMessageConstant.ForgetPassword.MESSAGE,
                    ErrorMessageConstant.ForgetPassword.DEVELOPER_MESSAGE);
        }

        LOGGER.info(":::: ADMIN PASSWORD VALIDATED ::::");
    };
}
