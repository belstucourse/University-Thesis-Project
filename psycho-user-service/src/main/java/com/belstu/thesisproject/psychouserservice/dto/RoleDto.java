package com.belstu.thesisproject.psychouserservice.dto;

import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RoleDto {
  @NotBlank private String id;
  @NotBlank private String name;
}
