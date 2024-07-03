package com.temporintech.animalhaven.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_VACCINE")
public class Vaccine implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	@Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Date applicationDate;
    @Column(nullable = false)
    private String manufacturer;
    @Column(nullable = false)
    private String lotNumber;
    @Column(nullable = false)
    private String responsibleVeterinarian;
    
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
	public Date getApplicationDate() {
		return applicationDate;
	}
	public void setApplicationDate(Date applicationDate) {
		this.applicationDate = applicationDate;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getLotNumber() {
		return lotNumber;
	}
	public void setLotNumber(String lotNumber) {
		this.lotNumber = lotNumber;
	}
	public String getResponsibleVeterinarian() {
		return responsibleVeterinarian;
	}
	public void setResponsibleVeterinarian(String responsibleVeterinarian) {
		this.responsibleVeterinarian = responsibleVeterinarian;
	}
}