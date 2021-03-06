package edu.miu.userservice.repository;

import edu.miu.userservice.model.Role;
import edu.miu.userservice.model.User;
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
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);

    @Query("SELECT r FROM Role r WHERE r.status=:status")
    List<Role> findAllRoles(boolean status);
}
