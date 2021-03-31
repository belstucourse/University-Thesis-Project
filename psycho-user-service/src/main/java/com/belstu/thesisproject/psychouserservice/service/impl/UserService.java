package com.belstu.thesisproject.psychouserservice.service.impl;

import com.belstu.thesisproject.psychouserservice.domain.User;
import com.belstu.thesisproject.psychouserservice.exception.UserNotFoundException;

public interface UserService {
  User getUserById(final String id) throws UserNotFoundException;

  User save(final User user);

  User getUserByUsername(final String username) throws UserNotFoundException;
}
