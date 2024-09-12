package com.rocket.healingpets.Reservations.repository;

import com.rocket.healingpets.Reservations.model.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationsRepository extends JpaRepository<Reservation, Integer> {
}
