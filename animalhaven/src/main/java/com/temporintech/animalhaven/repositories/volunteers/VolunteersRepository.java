package com.temporintech.animalhaven.repositories.volunteers;

import java.util.UUID;

import com.temporintech.animalhaven.model.volunteers.VolunteersModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VolunteersRepository extends JpaRepository<VolunteersModel, UUID> {

}