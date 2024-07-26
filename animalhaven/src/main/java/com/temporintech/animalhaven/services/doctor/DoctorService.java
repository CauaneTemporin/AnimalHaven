package com.temporintech.animalhaven.services.doctor;

import org.springframework.stereotype.Service;

import com.temporintech.animalhaven.dtos.DoctorRecordDTO;
import com.temporintech.animalhaven.model.DoctorModel;
import com.temporintech.animalhaven.services.CrudService;


@Service
public interface DoctorService extends CrudService<DoctorModel, DoctorRecordDTO>{

}