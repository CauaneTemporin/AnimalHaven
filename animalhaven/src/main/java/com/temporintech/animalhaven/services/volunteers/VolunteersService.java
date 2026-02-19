package com.temporintech.animalhaven.services.volunteers;

import com.temporintech.animalhaven.dtos.volunteers.VolunteersDTO;
import com.temporintech.animalhaven.model.volunteers.VolunteersModel;
import org.springframework.stereotype.Service;

import com.temporintech.animalhaven.services.CrudService;


@Service
public interface VolunteersService extends CrudService<VolunteersModel, VolunteersDTO> {

}