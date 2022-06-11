package edu.miu.userservice.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user")
@Getter
@Setter
public class User implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "username", length = 20, nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "name", nullable = false, length = 30)
    private String name;

    @Column(name = "email", nullable = false, length = 100)
    private String email;

    @Column(name = "subscribed")
    public Boolean subscribed;

    @ElementCollection(fetch = FetchType.EAGER)
    @Builder.Default
    private List<String> roles = new ArrayList<>();

    public User() {
    }

    public User(String username, String password, String email, Boolean subscribed, String name, List<String> roles) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.subscribed = subscribed;
        this.roles = roles;
    }
}
