package com.ccms.musician.domain.model.entity;

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
@Table(name = "musicians")
public class Musician {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 60)
    private String name;

    @NotNull
    @NotBlank
    @Column(unique = true)
    private String email;

    private long phoneNumber;

}
