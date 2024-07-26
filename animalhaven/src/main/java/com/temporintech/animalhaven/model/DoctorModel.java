package com.temporintech.animalhaven.model;

import java.io.Serializable;
import java.util.UUID;

import com.temporintech.animalhaven.enums.status.Status;

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
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_DOCTOR")
@Data
@NoArgsConstructor
public class DoctorModel  {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String specialization;
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Status status;
}