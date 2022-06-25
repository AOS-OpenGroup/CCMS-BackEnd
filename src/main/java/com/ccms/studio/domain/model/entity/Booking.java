package com.ccms.studio.domain.model.entity;
import com.ccms.shared.domain.model.AuditModel;
import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bookings")
public class Booking extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Id
    private Long musicianId;

    @Id
    private Long StudioId;

    @NotNull
    @NotBlank
    private String date;

    @NotNull
    @NotBlank
    private String time;

}
