package com.temporintech.animalhaven.services.doctor;

import java.util.List;
import java.util.UUID;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.temporintech.animalhaven.dtos.DoctorRecordDTO;
import com.temporintech.animalhaven.model.DoctorModel;
import com.temporintech.animalhaven.repositories.DoctorRepository;
import com.temporintech.animalhaven.services.exceptions.AssociationException;
import com.temporintech.animalhaven.services.exceptions.ResourceNotFoundException;
import com.temporintech.animalhaven.services.vaccine.VaccineService;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

	private final DoctorRepository repository;
	private final VaccineService service;
	@Transactional
	public DoctorModel save(DoctorRecordDTO dto) {
		var model = new DoctorModel();
		BeanUtils.copyProperties(dto, model);
		return repository.save(model);
	}

	@Transactional
	public DoctorModel update(UUID id, DoctorRecordDTO dto) {
		var doctorModel = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Doctor with ID " + id + " not found"));
		BeanUtils.copyProperties(dto, doctorModel);
		return repository.save(doctorModel);
	}

	public List<DoctorModel> findAll() {
		return repository.findAll();
	}

	public DoctorModel findById(UUID id) {
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Doctor with ID " + id + " not found"));
	}

	@Transactional
	public void delete(UUID id) {
		DoctorModel doctorModel = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Doctor with ID " + id + " not found"));

		boolean isAssociated = service.existsByDoctorId(id);
		if (isAssociated) {
			throw new AssociationException("Doctor with ID " + id + " is associated with one or more vaccine");
		}

		repository.delete(doctorModel);
	}
}
