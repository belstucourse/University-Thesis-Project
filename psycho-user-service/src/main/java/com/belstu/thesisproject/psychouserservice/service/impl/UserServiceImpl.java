package com.belstu.thesisproject.psychouserservice.service.impl;

import com.belstu.thesisproject.psychouserservice.domain.User;
import com.belstu.thesisproject.psychouserservice.exception.UserNotFoundException;
import com.belstu.thesisproject.psychouserservice.repository.RoleRepository;
import com.belstu.thesisproject.psychouserservice.repository.UserRepository;
import com.belstu.thesisproject.psychouserservice.service.UserService;
import com.belstu.thesisproject.psychouserservice.updater.UserUpdater;
import javax.persistence.EntityNotFoundException;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@AllArgsConstructor
@Validated
public class UserServiceImpl implements UserService {
  private final UserRepository userRepository;
  private final UserUpdater userUpdater;
  private final RoleRepository roleRepository;

  @Override
  public User getUserById(@NotNull final String id) throws UserNotFoundException {
    return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
  }

  @Override
  public User save(@NotNull final User user) {
    return userRepository.save(user);
  }

  @Override
  public User getUserByEmail(@NotBlank final String username) throws UserNotFoundException {
    return userRepository
        .findByEmail(username)
        .orElseThrow(() -> new EntityNotFoundException(username));
  }

  @Override
  public User update(@NotNull final User newUser) throws UserNotFoundException {
    final String userId = newUser.getId();
    final User existingUser =
        userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
    return existingUser.update(userUpdater, newUser);
  }

  public void delete(@NotNull final String id) throws UserNotFoundException {
    userRepository.deleteById(id);
  }

  @Override
  public User patch(@NotNull User user) {
    return null;
  }
}
