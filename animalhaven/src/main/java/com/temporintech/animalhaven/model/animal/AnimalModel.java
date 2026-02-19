package com.temporintech.animalhaven.model.animal;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.temporintech.animalhaven.enums.util.Gender;
import com.temporintech.animalhaven.enums.animal.Health;
import com.temporintech.animalhaven.enums.animal.Status;

import com.temporintech.animalhaven.model.shelter.ShelterModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_ANIMAL")
@Data
@NoArgsConstructor
public class AnimalModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private int age;
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Gender gender;
	@Column(nullable = false)
	private double weight;
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Health health;
	@Column(nullable = false)
	private Date dateEntered;
	@Column(nullable = false)
	private String description;
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Status status;
	@Column(nullable = false)
	private boolean castrated;
	@Column(nullable = false)
	private LocalDateTime createdAt;

	@ManyToOne
	@JoinColumn(name = "species_id")
	private SpeciesModel species;

	@ManyToOne
	@JoinColumn(name = "shelter_id")
	private ShelterModel shelter;

	@ManyToMany
    @JoinTable(
        name = "animal_vaccine",
        joinColumns = @JoinColumn(name = "animal_id"),
        inverseJoinColumns = @JoinColumn(name = "vaccine_id")
    )
    private List<VaccineModel> vaccine = new ArrayList<>();
}