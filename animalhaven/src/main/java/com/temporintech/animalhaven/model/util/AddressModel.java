package com.temporintech.animalhaven.model.util;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "TB_ADDRESS")
@Data
@NoArgsConstructor
public class AddressModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false)
    private String street;
    @Column(nullable = false)
    private String number;
    @Column(nullable = false)
    private String complement;
    @Column(nullable = false)
    private String neighborhood;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String state;
    @Column(nullable = false)
    private String postalCode;
    @Column(nullable = false)
    private String country;
}