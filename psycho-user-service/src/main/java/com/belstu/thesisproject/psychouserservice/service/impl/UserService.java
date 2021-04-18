package com.belstu.thesisproject.psychouserservice.service.impl;

import com.belstu.thesisproject.psychouserservice.domain.User;
import com.belstu.thesisproject.psychouserservice.exception.UserNotFoundException;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public interface UserService {
    User getUserById(@NotNull final String id) throws UserNotFoundException;

    User save(@NotNull final User user);

    User getUserByEmail(@NotBlank final String username) throws UserNotFoundException;

    User update(@NotNull final User user) throws UserNotFoundException;

    void delete(@NotNull final String id) throws UserNotFoundException;

    User patch(@NotNull final User user);
}
