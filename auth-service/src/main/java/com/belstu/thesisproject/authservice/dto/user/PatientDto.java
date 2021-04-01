package com.belstu.thesisproject.authservice.dto.user;

import java.util.Set;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PatientDto extends UserDto {

  @Builder(builderMethodName = "childBuilder")
  public PatientDto(
      String id,
      String name,
      String username,
      String email,
      String password,
      Set<RoleDto> roles,
      Set<ComplaintDto> complaints) {
    super(id, name, username, email, password, roles, complaints);
  }
}
