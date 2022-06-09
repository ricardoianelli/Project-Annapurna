package edu.miu.userservice.dto.response;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Data
public class UserResponseDTO implements Serializable {
    private String name;
    private String email;
    private Boolean subscribed;
}
