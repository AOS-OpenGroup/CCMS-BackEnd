package com.ccms.musician.resource;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UpdateMusicianResource {
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 60)
    private String name;

    @NotNull
    @NotBlank
    private String email;

    @Size(max = 200)
    private Long phoneNumber;
}
