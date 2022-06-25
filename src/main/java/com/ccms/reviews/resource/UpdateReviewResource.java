package com.ccms.reviews.resource;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class UpdateReviewResource {
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 200)
    private String description;
}
