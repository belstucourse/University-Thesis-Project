package com.belstu.thesisproject.psychouserservice.service;

import com.belstu.thesisproject.psychouserservice.domain.Role;
import com.belstu.thesisproject.psychouserservice.domain.User;
import com.belstu.thesisproject.psychouserservice.dto.UserRole;

import javax.management.relation.RoleNotFoundException;
import javax.validation.constraints.NotNull;

public interface RoleService {
  Role findByName(@NotNull final UserRole userRole) throws RoleNotFoundException;

  void assignRoleToUser(@NotNull final User user);
}
