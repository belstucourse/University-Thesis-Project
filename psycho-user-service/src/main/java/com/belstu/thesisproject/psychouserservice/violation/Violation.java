package com.belstu.thesisproject.psychouserservice.violation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class Violation {
  private final String fieldName;

  private final String message;
}
