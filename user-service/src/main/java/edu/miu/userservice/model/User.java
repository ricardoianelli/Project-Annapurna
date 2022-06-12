package edu.miu.userservice.model;

import lombok.*;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static javax.persistence.FetchType.EAGER;

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

    @OneToMany(fetch = EAGER)
    private Collection<Role> roles = new ArrayList<>();

    public User() {
    }

    public User(String username, String password, String name, String email,
                Boolean subscribed, Collection<Role> roles) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.subscribed = subscribed;
        this.roles = roles;
    }
}
