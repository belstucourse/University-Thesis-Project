package com.belstu.thesisproject.complaintservice.service;

import com.belstu.thesisproject.complaintservice.domain.Complaint;

import javax.validation.constraints.NotNull;

public interface ComplaintService {
    Complaint getComplaintById(@NotNull final String id);

    Complaint getComplaintByClientId(@NotNull final String clientId);

    Complaint save(final Complaint complaint);

    Complaint update(final Complaint complaint);

    Complaint delete(final @NotNull Integer id);
}
