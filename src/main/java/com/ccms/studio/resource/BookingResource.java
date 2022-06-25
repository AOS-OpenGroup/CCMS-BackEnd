package com.ccms.studio.resource;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class BookingResource {
    private Long id;
    private Long musicianId;
    private Long StudioId;
    private String date;
    private String time;
}
