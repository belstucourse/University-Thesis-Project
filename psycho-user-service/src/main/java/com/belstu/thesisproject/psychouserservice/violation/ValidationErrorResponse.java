package com.belstu.thesisproject.psychouserservice.violation;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class ValidationErrorResponse {
  private List<Violation> violations = new ArrayList<>();
}
