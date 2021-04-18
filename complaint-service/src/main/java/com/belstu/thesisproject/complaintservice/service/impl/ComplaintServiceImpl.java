package com.belstu.thesisproject.complaintservice.service.impl;

import com.belstu.thesisproject.complaintservice.domain.Complaint;
import com.belstu.thesisproject.complaintservice.exception.ComplaintNotFoundException;
import com.belstu.thesisproject.complaintservice.repository.ComplaintRepository;
import com.belstu.thesisproject.complaintservice.service.ComplaintService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import javax.validation.constraints.NotNull;

@Service
@AllArgsConstructor
public class ComplaintServiceImpl implements ComplaintService {
    private final ComplaintRepository complaintRepository;

    @Override
    public Complaint getComplaintById(@NotNull final String id) {
        return complaintRepository.findById(id).orElseThrow(() -> new ComplaintNotFoundException(id));
    }

    @Override
    public Complaint getComplaintByClientId(@NotNull final String clientId) {
        return complaintRepository.findByClientId(clientId).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Complaint save(final Complaint complaint) {
        return complaintRepository.save(complaint);
    }

    @Override
    public Complaint update(final Complaint complaint) {
        return complaintRepository.save(complaint);
    }

    @Override
    public void delete(@NotNull final String id) {
        complaintRepository.deleteById(id);
    }
}
