package com.belstu.thesisproject.authservice.dto.user;

import com.fasterxml.jackson.annotation.JsonTypeName;
import java.time.LocalDate;
import java.util.Set;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Getter
@Setter
@JsonTypeName("psychologist")
public class PsychologistDto extends UserDto {
  private Boolean verified;

  private LocalDate verifiedDate;

  private String mobile;

  private Set<TagDto> tags;

  public PsychologistDto(
      String id,
      String firstName,
      String middleName,
      String lastName,
      LocalDate registerDate,
      Boolean deactivated,
      LocalDate deactivatedDate,
      String imageUrl,
      String email,
      String password,
      Set<RoleDto> roles,
      Boolean verified,
      LocalDate verifiedDate,
      String mobile,
      Set<TagDto> tags) {
    super(
        id,
        firstName,
        middleName,
        lastName,
        registerDate,
        deactivated,
        deactivatedDate,
        imageUrl,
        email,
        password,
        roles);
    this.verified = verified;
    this.verifiedDate = verifiedDate;
    this.mobile = mobile;
    this.tags = tags;
  }
}
