package com.rocket.healingpets.users.repository;

import com.rocket.healingpets.users.model.entitiy.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PetRepository extends JpaRepository<Pet, Integer> {

    List<Pet> findAllByUser_UserId(String userId);
}
