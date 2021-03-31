package com.belstu.thesisproject.authservice.dto.user;

import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UserDto {
  private String id;

  private String name;
  private String username;
  private String email;
  private String password;

  private Set<RoleDto> roles;

  private Set<ComplaintDto> complaints;
}
