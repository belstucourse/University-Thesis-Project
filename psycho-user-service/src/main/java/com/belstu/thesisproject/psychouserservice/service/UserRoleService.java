package com.belstu.thesisproject.psychouserservice.service;

import com.belstu.thesisproject.psychouserservice.domain.User;
import javax.validation.constraints.NotNull;

public interface UserRoleService {
  void setUserRole(@NotNull final User user);
}
