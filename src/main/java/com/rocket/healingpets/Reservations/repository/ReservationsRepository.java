package com.rocket.healingpets.Reservations.repository;

import com.rocket.healingpets.Reservations.model.entity.Reservation;
import com.rocket.healingpets.hospitals.model.entity.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationsRepository extends JpaRepository<Reservation, Integer> {
    List<Reservation> findReservationsByHosId(Hospital hospital);
}
