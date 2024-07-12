package com.temporintech.animalhaven.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.UUID;

import com.temporintech.animalhaven.enums.animal.Gender;
import com.temporintech.animalhaven.enums.animal.Health;
import com.temporintech.animalhaven.enums.animal.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_ANIMAL")
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

	@ManyToOne
	@JoinColumn(name = "species_id", nullable = false)
	private SpeciesModel species;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public Health getHealth() {
		return health;
	}

	public void setHealth(Health health) {
		this.health = health;
	}

	public Date getDateEntered() {
		return dateEntered;
	}

	public void setDateEntered(Date dateEntered) {
		this.dateEntered = dateEntered;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public boolean isCastrated() {
		return castrated;
	}

	public void setCastrated(boolean castrated) {
		this.castrated = castrated;
	}

	public SpeciesModel getSpecies() {
		return species;
	}

	public void setSpecies(SpeciesModel species) {
		this.species = species;
	}
}