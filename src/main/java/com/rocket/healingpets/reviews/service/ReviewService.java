package com.rocket.healingpets.reviews.service;

import com.rocket.healingpets.Reservations.model.entity.Reservation;
import com.rocket.healingpets.Reservations.repository.ReservationsRepository;
import com.rocket.healingpets.reviews.model.dto.CreateReviewDTO;
import com.rocket.healingpets.reviews.model.dto.ReadReviewDTO;
import com.rocket.healingpets.reviews.model.dto.ReviewDTO;
import com.rocket.healingpets.reviews.model.entity.Review;
import com.rocket.healingpets.reviews.repository.ReviewRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final ReservationsRepository reservationsRepository;
    private final ModelMapper modelMapper;


    // 리뷰 전체 조회
    public List<ReadReviewDTO> findAllReview() {
        List<Review> allReview = reviewRepository.findAll();

        return allReview.stream()
                .map(review -> modelMapper.map(review, ReadReviewDTO.class))
                .collect(Collectors.toList());
    }


    //리뷰 아이디를 통해 특정 리뷰 조회
    public ReviewDTO findReviewById(String reviewId) {

        Review review = reviewRepository.findById(Integer.valueOf(reviewId))
                .orElseThrow(() -> new EntityNotFoundException("리뷰를 조회할 수 없습니다."));

        ReviewDTO reviewDTO = new ReviewDTO();
        reviewDTO.setReviewId(review.getReviewId());
        reviewDTO.setContent(review.getContent());
        reviewDTO.setReportState(review.getReportState());
        reviewDTO.setCreatedDate(review.getCreatedDate());
        reviewDTO.setLastModifiedDate(review.getLastModifiedDate());

        reviewDTO.setReservationId(review.getReservation().getReservationId());

        reviewDTO.setUserid(review.getReservation().getUserId().getUserId());
        reviewDTO.setUserName(review.getReservation().getUserId().getUserName());
        reviewDTO.setClinicName(review.getReservation().getClinicType().getClinicName());

        reviewDTO.setName(review.getReservation().getHosId().getName());
        reviewDTO.setAddress(review.getReservation().getHosId().getAddress());

        return reviewDTO;

    }

    // 리뷰 등록
    public Review createReview(CreateReviewDTO createReviewDTO, int reservationId) {
        // Reservation을 먼저 조회
        Reservation reservation = reservationsRepository.findById(reservationId)
                .orElseThrow(() -> new EntityNotFoundException("해당 예약을 찾을 수 없습니다."));

        // Review 엔티티 생성 및 값 설정
        Review review = new Review();
        review.setReservation(reservation);  // Review와 Reservation 연결
        review.setContent(createReviewDTO.getContent());

        // Review 저장 (이때 reviewId는 reservationId와 동일하게 설정됨)
        return reviewRepository.save(review);
    }

    // 리뷰 수정
    public Review modifyReview(int reviewId, CreateReviewDTO reviewDTO) {

        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new EntityNotFoundException("리뷰를 찾을 수 없습니다."));

        review.setContent(reviewDTO.getContent());

        return reviewRepository.save(review);

    }

    // 리뷰 삭제
    public void deleteReview(int reviewId) {

        Review review = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new EntityNotFoundException("리뷰를 찾을 수 없습니다."));

        reviewRepository.delete(review);
    }
}
