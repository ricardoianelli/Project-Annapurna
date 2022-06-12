package edu.miu.emailservice.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bijayshrestha on 6/12/22
 * @project cs544-project
 */
@RestController
@RequestMapping("/email")
public class EmailResource {

    @GetMapping
    public String test(){
        return "It's working";
    }
}
