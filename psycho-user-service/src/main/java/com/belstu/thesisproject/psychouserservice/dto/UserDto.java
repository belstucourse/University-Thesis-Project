package com.belstu.thesisproject.psychouserservice.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@JsonTypeInfo(use=JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type()
})
public class UserDto {
  private String id;

  private String name;
  private String username;
  private String email;
  private String password;

  private Set<RoleDto> roles;

  private Set<ComplaintDto> complaints;
}
