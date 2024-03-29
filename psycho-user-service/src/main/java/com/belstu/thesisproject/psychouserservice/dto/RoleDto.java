package com.belstu.thesisproject.psychouserservice.dto;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RoleDto {
  private String id;
  @NotNull private UserRole userRole;
}
