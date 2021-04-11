package com.belstu.thesisproject.psychouserservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ComplaintDto {
  private String id;

  private ComplaintType complaintType;

  private String title;
  private String message;
}
