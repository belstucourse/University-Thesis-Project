package com.belstu.thesisproject.psychouserservice.dto;

import com.belstu.thesisproject.psychouserservice.valiadator.OnCreate;
import com.belstu.thesisproject.psychouserservice.valiadator.OnUpdate;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import java.time.LocalDate;
import java.util.Set;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
  @Null(groups = OnCreate.class)
  @NotBlank(groups = OnUpdate.class)
  private String id;

  @NotBlank private String firstName;
  @NotBlank private String middleName;
  @NotBlank private String lastName;

  @PastOrPresent(groups = OnUpdate.class)
  @Null(groups = OnCreate.class)
  private LocalDate registerDate;

  private Boolean deactivated;

  private LocalDate deactivatedDate;

  private String imageUrl;

  @NotBlank private String email;

  @NotBlank(groups = OnCreate.class)
  private String password;

  @NotNull private Set<RoleDto> roles;
}
