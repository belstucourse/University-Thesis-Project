package com.belstu.thesisproject.complaintservice.dto.user;

import com.belstu.thesisproject.complaintservice.validator.CreationValidator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TagDto {
    @NotBlank(groups = CreationValidator.class)
    private String id;
    @NotBlank
    private String name;
}
