package com.belstu.thesisproject.psychouserservice.updater;

import com.belstu.thesisproject.psychouserservice.domain.Admin;
import com.belstu.thesisproject.psychouserservice.domain.Client;
import com.belstu.thesisproject.psychouserservice.domain.Psychologist;
import com.belstu.thesisproject.psychouserservice.domain.Support;
import com.belstu.thesisproject.psychouserservice.domain.User;
import com.belstu.thesisproject.psychouserservice.repository.UserRepository;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class UserUpdater {
  private final UserRepository userRepository;

  public Admin update(final Admin existingUser, final Admin newUser) {
    return updateBasicUser(existingUser, newUser).save(userRepository::save);
  }

  public Client update(final Client existingUser, final Client newUser) {
    return updateBasicUser(existingUser, newUser).save(userRepository::save);
  }

  public Psychologist update(final Psychologist existingUser, final Psychologist newUser) {
    return updateBasicUser(existingUser, newUser)
        .update(newUser::getMobile, existingUser::setMobile)
        .save(userRepository::save);
  }

  public Support update(final Support existingUser, final Support newUser) {
    return updateBasicUser(existingUser, newUser).save(userRepository::save);
  }

  private <T extends User> UpdateUtility<T> updateBasicUser(
      @NotNull final T existingUser, @NotNull final T newUser) {
    return UpdateUtility.start(existingUser)
        .update(newUser::getDeactivated, existingUser::setDeactivated)
        .update(newUser::getDeactivatedDate, existingUser::setDeactivatedDate)
        .update(newUser::getEmail, existingUser::setEmail)
        .update(newUser::getFirstName, existingUser::setFirstName)
        .update(newUser::getImageUrl, existingUser::setImageUrl)
        .update(newUser::getLastName, existingUser::setLastName)
        .update(newUser::getLastName, existingUser::setLastName)
        .update(newUser::getMiddleName, existingUser::setMiddleName)
        .update(newUser::getRegisterDate, existingUser::setRegisterDate)
        .update(newUser::getRoles, existingUser::setRoles);
  }
}
