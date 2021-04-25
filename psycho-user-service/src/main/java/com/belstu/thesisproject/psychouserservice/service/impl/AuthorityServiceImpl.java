package com.belstu.thesisproject.psychouserservice.service.impl;

import com.belstu.thesisproject.psychouserservice.domain.Authority;
import com.belstu.thesisproject.psychouserservice.repository.AuthorityRepository;
import com.belstu.thesisproject.psychouserservice.service.AuthorityService;
import javax.management.relation.RoleNotFoundException;
import javax.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorityServiceImpl implements AuthorityService {
  private final AuthorityRepository authorityRepository;

  @Override
  public Authority findByName(@NotNull final String name) throws RoleNotFoundException {
    return authorityRepository.findByName(name).orElseThrow(RoleNotFoundException::new);
  }

  @Override
  public Authority saveAuthority(@NotNull final Authority authority) {
    return authorityRepository.save(authority);
  }
}
