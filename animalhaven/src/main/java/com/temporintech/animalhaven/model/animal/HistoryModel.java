package com.temporintech.animalhaven.model.animal;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "TB_ANIMAL_CONDUCT")
@Data
@NoArgsConstructor
public class HistoryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false)
    private String observation;
}