package com.belstu.thesisproject.psychouserservice.dto;

import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDto {
  private String id;

  private String name;
  private String username;
  private String email;
  private String password;

  private Set<RoleDto> roles;

  private Set<ComplaintDto> complaints;
}
