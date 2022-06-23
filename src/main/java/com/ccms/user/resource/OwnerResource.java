package com.ccms.user.resource;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class OwnerResource {
    private Long id;
    private String name;
    private String email;
    private Long phoneNumber;
}
