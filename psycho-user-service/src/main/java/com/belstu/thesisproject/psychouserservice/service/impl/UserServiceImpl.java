package com.belstu.thesisproject.psychouserservice.service.impl;

import com.belstu.thesisproject.psychouserservice.domain.Role;
import com.belstu.thesisproject.psychouserservice.domain.User;
import com.belstu.thesisproject.psychouserservice.exception.UserNotFoundException;
import com.belstu.thesisproject.psychouserservice.repository.UserRepository;
import com.belstu.thesisproject.psychouserservice.service.RoleService;
import com.belstu.thesisproject.psychouserservice.service.UserService;
import com.belstu.thesisproject.psychouserservice.updater.UserUpdater;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Service
@AllArgsConstructor
@Validated
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserUpdater userUpdater;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User getUserById(@NotNull final String id) throws UserNotFoundException {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    @Override
    @Transactional
    public User save(@NotNull final User user) {
        final Set<Role> roles = user.getRoles();
        roleService.assignRoleToUser(user);
        encodePassword(user);
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

    private void encodePassword(final User user) {
        final String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
    }
}
