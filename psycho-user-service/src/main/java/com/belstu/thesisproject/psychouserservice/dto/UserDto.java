package com.belstu.thesisproject.psychouserservice.dto;

import java.time.LocalDate;
import java.util.Set;

import com.belstu.thesisproject.psychouserservice.domain.Role;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

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
