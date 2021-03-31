package com.belstu.thesisproject.psychouserservice.service;

import com.belstu.thesisproject.psychouserservice.domain.User;
import com.belstu.thesisproject.psychouserservice.exception.UserNotFoundException;
import com.belstu.thesisproject.psychouserservice.repository.UserRepository;
import com.belstu.thesisproject.psychouserservice.service.impl.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
  private final UserRepository userRepository;

  @Override
  public User getUserById(final String id) throws UserNotFoundException {
    return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
  }

  @Override
  public User save(final User user) {
    return userRepository.save(user);
  }

  @Override
  public User getUserByUsername(final String username) throws UserNotFoundException {
    return userRepository.findByUsername(username).orElseThrow(UserNotFoundException::new);
  }
}
