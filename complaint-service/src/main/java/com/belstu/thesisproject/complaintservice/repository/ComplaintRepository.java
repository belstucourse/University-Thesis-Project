package com.belstu.thesisproject.complaintservice.repository;

import com.belstu.thesisproject.complaintservice.domain.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ComplaintRepository extends JpaRepository<Complaint, String> {
    Optional<Complaint> findByClientId(final String clientId);
    void deleteById(final String id);
}
