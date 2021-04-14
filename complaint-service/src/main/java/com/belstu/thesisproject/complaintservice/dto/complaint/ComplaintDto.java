package com.belstu.thesisproject.complaintservice.dto.complaint;

import com.belstu.thesisproject.complaintservice.domain.ComplaintType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ComplaintDto {
  private String id;

  private String reviewerId;
  private String clientId;

  private ComplaintType complaintType;

  private String title;
  private String complaintText;
  private String answerText;

  private LocalDate reviewDate;
  private LocalDate creationDate;
}
