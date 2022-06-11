package edu.miu.loginservice.controller;

import edu.miu.loginservice.constant.WebResourceKeyConstant;
import edu.miu.loginservice.dto.request.LoginRequestDTO;
import edu.miu.loginservice.service.LoginService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.http.ResponseEntity.ok;

/**
 * @author bijayshrestha on 6/10/22
 * @project cs544-project
 */
@RestController
@RequestMapping(value = WebResourceKeyConstant.BASE_API)
public class LoginController {
    private final LoginService loginService;

    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping(value = WebResourceKeyConstant.LOGIN)
    public ResponseEntity<String> loginUser(@RequestBody LoginRequestDTO requestDTO,
                                            HttpServletRequest request) {

        String token = loginService.login(requestDTO, request);
        return ok().body(token);
    }

    @GetMapping("/test")
    public String test() {
        return "test done";
    }
}
