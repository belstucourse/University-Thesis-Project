package com.belstu.thesisproject.complaintservice.dto.user;

import com.belstu.thesisproject.complaintservice.validator.CreationValidator;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(SupportDto.class),
        @JsonSubTypes.Type(PsychologistDto.class),
        @JsonSubTypes.Type(ClientDto.class),
        @JsonSubTypes.Type(AdminDto.class)
})
public abstract class UserDto {
  @NotBlank(groups = CreationValidator.class)
  private String id;
  @NotBlank
  private String firstName;
  @NotBlank
  private String middleName;
  @NotBlank
  private String lastName;
  @PastOrPresent
  private LocalDate registerDate;

  private Boolean deactivated;
  @PastOrPresent
  private LocalDate deactivatedDate;

  private String imageUrl;
  @NotBlank
  private String email;

  private String password;

  private Set<RoleDto> roles;
}
