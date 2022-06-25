package com.ccms.studio.domain.model.entity;
import com.ccms.shared.domain.model.AuditModel;
import com.ccms.users.owner.domain.model.entity.Owner;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "studios")
public class Studio extends AuditModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@Column(name = "owner_id")
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 60)
    private String name;

    private String address;

    @NotNull
    @NotBlank
    @Column(unique = true)
    private String email;

    @Size(max = 200)
    private String description;

    /*@OneToOne
    @MapsId
    @JoinColumn(name = "owner_id")
    private Owner owner;*/

    //consider joining with equipment
}
