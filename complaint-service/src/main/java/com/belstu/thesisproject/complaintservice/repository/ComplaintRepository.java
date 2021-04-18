package com.belstu.thesisproject.complaintservice.repository;

import com.belstu.thesisproject.complaintservice.domain.Complaint;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplaintRepository extends JpaRepository<Complaint, String> {
  Optional<Complaint> findByClientId(final String clientId);

  void deleteById(final String id);
}
