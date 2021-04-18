package com.belstu.thesisproject.complaintservice.dto.complaint;

import com.belstu.thesisproject.complaintservice.domain.ComplaintType;
import java.time.LocalDate;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ComplaintDto {
  private String id;

  @NotNull(message = "Reviewer can't be null")
  private String reviewerId;

  @NotNull(message = "Client can't be null")
  private String clientId;

  @NotNull private ComplaintType complaintType;

  @NotBlank private String title;
  @NotBlank private String complaintText;
  @NotBlank private String answerText;

  @PastOrPresent private LocalDate reviewDate;
  @PastOrPresent private LocalDate creationDate;
}
