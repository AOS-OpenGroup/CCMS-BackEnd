package com.ccms.studio.resource;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class CreateStudioResource {
    @NotNull
    @NotBlank
    @Size(max = 60)
    private String name;
    private String address;
    @NotNull
    @NotBlank
    private String email;
    @Size(max = 200)
    private String description;
}
