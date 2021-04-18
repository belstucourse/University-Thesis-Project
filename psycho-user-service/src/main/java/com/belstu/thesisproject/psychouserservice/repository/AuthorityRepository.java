package com.belstu.thesisproject.psychouserservice.repository;

import com.belstu.thesisproject.psychouserservice.domain.Authority;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, String> {
  Optional<Authority> findByName(String name);
}
