package com.belstu.thesisproject.psychouserservice.repository;

import com.belstu.thesisproject.psychouserservice.domain.Role;
import com.belstu.thesisproject.psychouserservice.dto.UserRole;
import java.util.Optional;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, String> {
  Optional<Role> findByUserRole(UserRole userRole);

  Set<Role> findAllByUserRole(Set<UserRole> userRoles);
}
