package com.belstu.thesisproject.psychouserservice.violation;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Data
public class ValidationErrorResponse {
    private List<Violation> violations = new ArrayList<>();
}
