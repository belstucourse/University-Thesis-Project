package com.belstu.thesisproject.complaintservice.controller;

import static org.springframework.http.HttpStatus.OK;

import com.belstu.thesisproject.complaintservice.domain.Complaint;
import com.belstu.thesisproject.complaintservice.dto.complaint.ComplaintDto;
import com.belstu.thesisproject.complaintservice.mapper.ComplaintMapper;
import com.belstu.thesisproject.complaintservice.service.ComplaintService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/complaint")
@AllArgsConstructor
public class ComplaintController {
  private final ComplaintService complaintService;
  private final ComplaintMapper complaintMapper;

  @GetMapping("/{id}")
  public ComplaintDto getComplaintById(@PathVariable final String id) {
    return complaintMapper.map(complaintService.getComplaintById(id));
  }

  @GetMapping
  public ComplaintDto getComplaintByClientId(@RequestParam final String clientId) {
    return complaintMapper.map(complaintService.getComplaintByClientId(clientId));
  }

  @PostMapping
  public ComplaintDto saveComplaint(@RequestBody final ComplaintDto complaintDto) {
    final Complaint complaint = complaintMapper.map(complaintDto);
    return complaintMapper.map(complaintService.save(complaint));
  }

  @PutMapping
  public ComplaintDto updateComplaint(@RequestBody final ComplaintDto complaintDto) {
    final Complaint complaint = complaintMapper.map(complaintDto);
    return complaintMapper.map(complaintService.update(complaint));
  }

  @DeleteMapping("/{id}")
  @ResponseStatus(OK)
  public void deleteById(@PathVariable final String id) {
    complaintService.delete(id);
  }
}
