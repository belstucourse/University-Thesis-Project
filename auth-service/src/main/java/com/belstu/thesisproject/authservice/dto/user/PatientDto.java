package com.belstu.thesisproject.authservice.dto.user;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
public class PatientDto extends UserDto {

    @Builder(builderMethodName = "childBuilder")

    public PatientDto(String id, String name, String username, String email, String password, Set<RoleDto> roles, Set<ComplaintDto> complaints) {
        super(id, name, username, email, password, roles, complaints);
    }
}
