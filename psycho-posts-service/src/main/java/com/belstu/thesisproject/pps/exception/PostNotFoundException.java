package com.belstu.thesisproject.pps.exception;

public class PostNotFoundException extends Exception {
  public PostNotFoundException(final String id) {
    super(String.format("Post with %s id not found", id));
  }
}
