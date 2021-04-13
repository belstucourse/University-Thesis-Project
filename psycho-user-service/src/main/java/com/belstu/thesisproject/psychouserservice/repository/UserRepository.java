package com.belstu.thesisproject.psychouserservice.repository;

import com.belstu.thesisproject.psychouserservice.domain.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
  Optional<User> findByUsername(final String username);
  Optional<User> deleteById(final int id);
}
