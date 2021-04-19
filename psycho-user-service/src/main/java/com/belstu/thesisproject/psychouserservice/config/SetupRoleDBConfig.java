package com.belstu.thesisproject.psychouserservice.config;

import static java.util.Arrays.asList;

import com.belstu.thesisproject.psychouserservice.domain.Authority;
import com.belstu.thesisproject.psychouserservice.domain.Role;
import com.belstu.thesisproject.psychouserservice.repository.AuthorityRepository;
import com.belstu.thesisproject.psychouserservice.repository.RoleRepository;
import com.belstu.thesisproject.psychouserservice.repository.UserRepository;
import java.util.HashSet;
import java.util.Set;
import javax.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SetupRoleDBConfig implements ApplicationListener<ContextRefreshedEvent> {
  boolean alreadySetup = false;

  private final UserRepository userRepository;

  private final RoleRepository roleRepository;

  private final AuthorityRepository authorityRepository;

  private final PasswordEncoder passwordEncoder;

  @Override
  @Transactional
  public void onApplicationEvent(final ContextRefreshedEvent event) {

    if (alreadySetup) return;
    final Authority readAuthority = createAuthorityIfNotFound("READ");
    final Authority writeAuthority = createAuthorityIfNotFound("WRITE");
    final Authority updateAuthority = createAuthorityIfNotFound("UPDATE");
    final Authority deleteAuthority = createAuthorityIfNotFound("DELETE");

    final Set<Authority> adminAuthorities =
        new HashSet<>(asList(readAuthority, writeAuthority, updateAuthority, deleteAuthority));
    final Set<Authority> clientAuthorities =
        new HashSet<>(asList(readAuthority, writeAuthority, updateAuthority));
    final Set<Authority> supportAuthorities =
        new HashSet<>(asList(readAuthority, writeAuthority, updateAuthority, deleteAuthority));
    final Set<Authority> psychologistAuthorities =
        new HashSet<>(asList(readAuthority, writeAuthority, updateAuthority));

    createRoleIfNotFound("ROLE_ADMIN", adminAuthorities);
    createRoleIfNotFound("ROLE_CLIENT", clientAuthorities);
    createRoleIfNotFound("ROLE_SUPPORT", supportAuthorities);
    createRoleIfNotFound("ROLE_PSYCHOLOGIST", psychologistAuthorities);

    alreadySetup = true;
  }

  private Authority createAuthorityIfNotFound(final String name) {

    return authorityRepository.findByName(name).orElse(createAuthority(name));
  }

  private Authority createAuthority(final String name) {
    final Authority authority = new Authority();
    authority.setName(name);
    return authorityRepository.save(authority);
  }

  private Role createRoleIfNotFound(final String name, final Set<Authority> authorities) {

    return roleRepository.findByName(name).orElse(createRole(name, authorities));
  }

  private Role createRole(final String name, final Set<Authority> authorities) {
    final Role role = new Role();
    role.setName(name);
    role.setAuthorities(authorities);
    return roleRepository.save(role);
  }
}
