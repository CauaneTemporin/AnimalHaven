package com.temporintech.animalhaven.model.animal;

import com.temporintech.animalhaven.enums.conduct.*;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "TB_ANIMAL_CONDUCT")
@Data
@NoArgsConstructor
public class ConductModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Temperament temperament;
    @Column(nullable = false)
    private EnergyLevel energyLevel;
    @Column(nullable = false)
    private Sociability sociability;
    @Column(nullable = false)
    private GoodWithChildren goodWithChildren;
    @Column(nullable = false)
    private GoodWithDogs goodWithDogs;
    @Column(nullable = false)
    private GoodWithCats goodWithCats;
    @Column(nullable = false)
    private TrainingLevel trainingLevel;
    @Column(nullable = false)
    private HouseTrained houseTrained;
    @Column(nullable = false)
    private BehavioralIssues behavioralIssues;
    @Column(nullable = false)
    private String observation;
}