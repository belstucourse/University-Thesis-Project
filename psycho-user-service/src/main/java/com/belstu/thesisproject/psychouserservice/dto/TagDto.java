package com.belstu.thesisproject.psychouserservice.dto;

import com.belstu.thesisproject.psychouserservice.valiadator.CreationValidator;
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
