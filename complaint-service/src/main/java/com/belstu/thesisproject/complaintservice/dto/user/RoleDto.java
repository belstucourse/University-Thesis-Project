package com.belstu.thesisproject.complaintservice.dto.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RoleDto {
  @NotBlank
  private String id;
  @NotBlank
  private String name;
}
