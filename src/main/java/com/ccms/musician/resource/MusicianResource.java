package com.ccms.musician.resource;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class MusicianResource {
    private Long id;
    private String name;
    private String email;
    private Long phoneNumber;
}
