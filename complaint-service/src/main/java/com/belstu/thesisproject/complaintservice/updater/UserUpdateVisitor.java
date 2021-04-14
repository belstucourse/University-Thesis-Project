package com.belstu.thesisproject.complaintservice.updater;

import com.belstu.thesisproject.psychouserservice.domain.User;

public interface UserUpdateVisitor<T extends User> {
    T update(final UserUpdater userUpdater, T newUser);
}
