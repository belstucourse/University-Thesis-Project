package com.belstu.thesisproject.complaintservice.mapper;

import com.belstu.thesisproject.complaintservice.domain.Complaint;
import com.belstu.thesisproject.complaintservice.dto.complaint.ComplaintDto;
import org.mapstruct.Mapper;

@Mapper
public interface ComplaintMapper {
    ComplaintDto map(final Complaint entity);

    Complaint map(final ComplaintDto dto);
}
