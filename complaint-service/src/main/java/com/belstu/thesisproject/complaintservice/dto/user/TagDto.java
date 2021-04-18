package com.belstu.thesisproject.complaintservice.dto.user;

import com.belstu.thesisproject.complaintservice.validator.CreationValidator;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TagDto {
  @NotBlank(groups = CreationValidator.class)
  private String id;

  @NotBlank private String name;
}
