package com.rocket.healingpets.reviews.repository;

import com.rocket.healingpets.Reservations.model.entity.Reservation;
import com.rocket.healingpets.hospitals.model.entity.Hospital;
import com.rocket.healingpets.reviews.model.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
    // 특정 병원 ID를 통해 후기를 조회하는 메서드
    @Query("SELECT r FROM Review r WHERE r.reservation.hosId.hosId = :hospitalId")
    List<Review> findReviewsByHosId(@Param("hospitalId") int hospitalId);

    @Query("SELECT r FROM Review r WHERE r.reservation.userId.userId = :userId")
    List<Review> findReviewsByUserId(@Param("userId") String userId);

    Review findByReservation(Reservation reservation);
}
