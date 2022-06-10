package com.ccms.studio.resource;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class StudioResource {
    private Long id;
    private String name;
    private String address;
    private String email;
    private String description;
}
