package com.temporintech.animalhaven.model;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_VACCINATION_CARD")
public class VaccinationCardModel implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	
	@ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private DoctorModel doctor;
	
	@ManyToOne
    @JoinColumn(name = "vaccine_id", nullable = false)
    private VaccineModel vaccine;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public DoctorModel getDoctor() {
		return doctor;
	}

	public void setDoctor(DoctorModel doctor) {
		this.doctor = doctor;
	}

	public VaccineModel getVaccine() {
		return vaccine;
	}

	public void setVaccine(VaccineModel vaccine) {
		this.vaccine = vaccine;
	}
}