package com.temporintech.animalhaven.services.sponsor;

import com.temporintech.animalhaven.dtos.sponsor.SponsorDTO;
import com.temporintech.animalhaven.dtos.volunteers.VolunteersDTO;
import com.temporintech.animalhaven.model.sponsor.SponsorModel;
import com.temporintech.animalhaven.services.CrudService;
import org.springframework.stereotype.Service;

@Service
public interface SponsorService extends CrudService<SponsorModel, SponsorDTO> {
}
