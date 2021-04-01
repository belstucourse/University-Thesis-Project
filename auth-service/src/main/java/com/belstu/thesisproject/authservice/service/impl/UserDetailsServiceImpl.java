package com.belstu.thesisproject.authservice.service.impl;

import static org.springframework.security.core.authority.AuthorityUtils.createAuthorityList;

import com.belstu.thesisproject.authservice.dto.user.RoleDto;
import com.belstu.thesisproject.authservice.dto.user.UserDto;
import com.belstu.thesisproject.authservice.service.UserService;
import java.util.Collection;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
  private final UserService userService;

  @Override
  public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
    final UserDto user = userService.getUserByUsername(username);
    return new User(
        user.getUsername(), user.getPassword(), convertRolesToAuthorities(user.getRoles()));
  }

  private Collection<? extends GrantedAuthority> convertRolesToAuthorities(
      final Collection<RoleDto> roles) {
    final String[] roleNames = roles.stream().map(RoleDto::getName).toArray(String[]::new);
    return createAuthorityList(roleNames);
  }
}
