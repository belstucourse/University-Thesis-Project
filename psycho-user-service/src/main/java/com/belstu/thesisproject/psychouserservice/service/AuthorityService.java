package com.belstu.thesisproject.psychouserservice.service;

import com.belstu.thesisproject.psychouserservice.domain.Authority;
import javax.management.relation.RoleNotFoundException;
import javax.validation.constraints.NotNull;

public interface AuthorityService {
  Authority findByName(@NotNull final String name) throws RoleNotFoundException;

  Authority saveAuthority(@NotNull final Authority authority);
}
