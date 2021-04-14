package com.belstu.thesisproject.complaintservice.service.impl;

import com.belstu.thesisproject.complaintservice.domain.Complaint;
import com.belstu.thesisproject.complaintservice.repository.ComplaintRepository;
import com.belstu.thesisproject.complaintservice.service.ComplaintService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

@Service
@AllArgsConstructor
public class ComplaintServiceImpl implements ComplaintService {
    private final ComplaintRepository complaintRepository;
    private final ComplaintUpdater;
    @Override
    public Complaint getComplaintById(@NotNull String id) {
        return null;
    }

    @Override
    public Complaint getComplaintByClientId(@NotNull String clientId) {
        return null;
    }

    @Override
    public Complaint save(Complaint complaint) {
        return null;
    }

    @Override
    public Complaint update(Complaint complaint) {
        return null;
    }

    @Override
    public Complaint delete(@NotNull Integer id) {
        return null;
    }
}
