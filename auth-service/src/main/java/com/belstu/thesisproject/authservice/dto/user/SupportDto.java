package com.belstu.thesisproject.authservice.dto.user;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.Set;

@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Getter
@Setter
@JsonTypeName("support")
public class SupportDto extends UserDto {
    private String createdAdminId;

    public SupportDto(String id, String firstName, String middleName, String lastName, LocalDate registerDate, Boolean deactivated, LocalDate deactivatedDate, String imageUrl, String email, String password, Set<RoleDto> roles, String createdAdminId) {
        super(id, firstName, middleName, lastName, registerDate, deactivated, deactivatedDate, imageUrl, email, password, roles);
        this.createdAdminId = createdAdminId;
    }
}
