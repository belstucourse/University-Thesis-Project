package com.belstu.thesisproject.psychouserservice.dto;

import java.util.Set;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Getter
@Setter
public class DoctorDto extends UserDto {

  @Builder(builderMethodName = "childBuilder")
  public DoctorDto(
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
