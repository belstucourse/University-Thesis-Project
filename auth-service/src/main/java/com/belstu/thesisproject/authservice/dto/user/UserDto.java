package com.belstu.thesisproject.authservice.dto.user;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.time.LocalDate;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// todo in the end recompile into separate jar archive
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
  @JsonSubTypes.Type(SupportDto.class),
  @JsonSubTypes.Type(PsychologistDto.class),
  @JsonSubTypes.Type(ClientDto.class),
  @JsonSubTypes.Type(AdminDto.class)
})
public abstract class UserDto {
  private String id;

  private String firstName;

  private String middleName;

  private String lastName;

  private LocalDate registerDate;

  private Boolean deactivated;

  private LocalDate deactivatedDate;

  private String imageUrl;

  private String email;

  private String password;

  private Set<RoleDto> roles;
}
