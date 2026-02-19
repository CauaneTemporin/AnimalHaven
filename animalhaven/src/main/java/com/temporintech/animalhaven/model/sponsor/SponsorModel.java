package com.temporintech.animalhaven.model.sponsor;

import com.temporintech.animalhaven.enums.util.Gender;
import com.temporintech.animalhaven.enums.util.Status;
import com.temporintech.animalhaven.model.util.AddressModel;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "TB_SPONSOR")
@Data
@NoArgsConstructor
public class SponsorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private LocalDate dateOfBirth;
    @Column(nullable = false)
    private Gender gender;
    @Column(nullable = false)
    private String nationalId;
    @Column(nullable = false)
    private String documentType;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String phone;
    @Column(nullable = false)
    private String secondaryPhone;
    @Column(nullable = false)
    private String occupation;
    @Column(nullable = false)
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "Address_id")
    private AddressModel addressModel;
}
