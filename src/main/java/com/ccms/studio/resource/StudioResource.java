package com.ccms.studio.resource;

import com.ccms.users.owner.resource.OwnerResource;
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
    //private OwnerResource owner;
}
