package com.ccms.studio.resource;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CreateBookingResource {
    @NotNull
    @NotBlank
    private String date;

    @NotNull
    @NotBlank
    private String time;
}
