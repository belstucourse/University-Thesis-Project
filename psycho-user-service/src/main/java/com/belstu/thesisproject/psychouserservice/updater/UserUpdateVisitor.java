package com.belstu.thesisproject.psychouserservice.updater;

import com.belstu.thesisproject.psychouserservice.domain.User;

public interface UserUpdateVisitor<T extends User> {
  T update(final UserUpdater userUpdater, T newUser);
}
