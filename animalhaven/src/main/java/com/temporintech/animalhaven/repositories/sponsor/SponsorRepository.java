package com.temporintech.animalhaven.repositories.sponsor;

import com.temporintech.animalhaven.model.sponsor.SponsorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SponsorRepository extends JpaRepository<SponsorModel, UUID> {

}