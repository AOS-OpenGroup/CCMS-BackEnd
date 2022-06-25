package com.ccms.studio.resource;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UpdateBookingResource {

    private Long id;
    private Long musicianId;
    private Long StudioId;

    @NotNull
    @NotBlank
    private String date;

    @NotNull
    @NotBlank
    private String time;

}
