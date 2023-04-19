package com.randradee.datatesting.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AlterColumnDTO {
    @NotBlank
    private String name;

    @NotBlank
    private String addOrDelete;

}
