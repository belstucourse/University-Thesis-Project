package com.belstu.thesisproject.complaintservice.repository;

import com.belstu.thesisproject.complaintservice.domain.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplaintRepository extends JpaRepository<Complaint, String> {
}
