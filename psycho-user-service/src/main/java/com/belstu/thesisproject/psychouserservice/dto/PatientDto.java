package com.belstu.thesisproject.psychouserservice.dto;

import com.belstu.thesisproject.psychouserservice.domain.Complaint;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
public class PatientDto extends UserDto{

    @Builder(builderMethodName = "childBuilder")
    public PatientDto(String id, String name, String username, String email, String password, Set<Complaint> complaints) {
        super(id, name, username, email, password, complaints);
    }
}
