package com.belstu.thesisproject.complaintservice.exception;

public class ComplaintNotFoundException extends RuntimeException {
    public ComplaintNotFoundException(final String message) {
        super(String.format("Complaint with %s id not found", message));
    }
}
