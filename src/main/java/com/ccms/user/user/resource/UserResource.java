package com.ccms.user.user.resource;

import lombok.*;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class UserResource {
    private Long id;
    private String name;
    private String email;
    private Long phoneNumber;
}
