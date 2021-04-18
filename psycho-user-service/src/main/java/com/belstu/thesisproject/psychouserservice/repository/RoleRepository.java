package com.belstu.thesisproject.psychouserservice.repository;

import com.belstu.thesisproject.psychouserservice.domain.Role;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, String> {
  Optional<Role> findByName(String name);
}
