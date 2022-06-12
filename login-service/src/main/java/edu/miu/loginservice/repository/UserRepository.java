package edu.miu.loginservice.repository;

import edu.miu.loginservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author bijayshrestha on 6/12/22
 * @project cs544-project
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.email=:email")
    Optional<User> findByEmail(String email);

    @Query("SELECT u FROM User u WHERE u.username=:username")
    Optional<User> findByUsername(String username);
}
