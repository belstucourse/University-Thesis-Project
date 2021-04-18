package com.belstu.thesisproject.psychouserservice.repository;

import com.belstu.thesisproject.psychouserservice.domain.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AuthorityRepository extends JpaRepository<Authority, String> {
    Optional<Authority> findByName(String name);
}
