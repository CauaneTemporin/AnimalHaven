package com.temporintech.animalhaven.repositories.adopter;

import com.temporintech.animalhaven.model.adopter.AdopterModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AdopterRepository extends JpaRepository<AdopterModel, UUID> {

}