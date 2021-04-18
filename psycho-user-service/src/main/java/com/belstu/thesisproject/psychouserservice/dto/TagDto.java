package com.belstu.thesisproject.psychouserservice.dto;

import com.belstu.thesisproject.psychouserservice.valiadator.OnCreate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TagDto {
    @NotBlank(groups = OnCreate.class)
    private String id;
    @NotBlank
    private String name;
}
