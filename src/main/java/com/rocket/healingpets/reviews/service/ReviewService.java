package com.rocket.healingpets.reviews.service;

import com.rocket.healingpets.Reservations.model.entity.Reservation;
import com.rocket.healingpets.Reservations.repository.ReservationsRepository;
import com.rocket.healingpets.hospitals.model.entity.ClinicType;
import com.rocket.healingpets.hospitals.model.entity.Hospital;
import com.rocket.healingpets.hospitals.model.entity.Hospital;
import com.rocket.healingpets.hospitals.repository.HospitalRepository;
import com.rocket.healingpets.reviews.model.dto.CreateReviewDTO;
import com.rocket.healingpets.reviews.model.dto.ReadReviewDTO;
import com.rocket.healingpets.reviews.model.dto.ReviewDTO;
import com.rocket.healingpets.reviews.model.entity.Review;
import com.rocket.healingpets.reviews.repository.ReviewRepository;
import com.rocket.healingpets.users.model.entitiy.User;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
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
    private final HospitalRepository hospitalRepository;
    // 필터링할 단어 목록
    private List<String> inappropriateWords = Arrays.asList(
            "바보", "멍청이", "존나", "꺼져", "쓰레기", "개새끼", "시발", "병신", "좆", "지랄",
            "미친", "개새", "개자식", "개년", "노답", "씹", "좆같은", "시발년", "정신병자",
            "지랄맞은", "쓰레기같은", "개소리", "병신같은", "간섭", "미친놈", "미친년", "찐따",
            "쓰레기 같은", "개자식 같은", "개새끼 같은", "이상한", "정신병", "후진", "거지",
            "지랄맞은",  "어리버리", "더러운", "개같은", "지랄", "쓰레기 같은", "노망"
    );

    // 리뷰 전체 조회
    public List<ReadReviewDTO> findAllReview() {
        List<Review> allReview = reviewRepository.findAll();

        return allReview.stream()
                .map(review -> modelMapper.map(review, ReadReviewDTO.class))
                .collect(Collectors.toList());
    }

    // 리뷰 전체 조회(하나씩)
    public List<ReviewDTO> findAllReview2() {
        List<Review> allReview = reviewRepository.findAll();

        return allReview.stream()
                .map(review -> {
                    ReviewDTO reviewDTO = new ReviewDTO();
                    reviewDTO.setContent(review.getContent());
                    reviewDTO.setReservationId(review.getReservation().getReservationId());
                    reviewDTO.setCreatedDate(review.getCreatedDate());
                    reviewDTO.setLastModifiedDate(review.getLastModifiedDate());
                    reviewDTO.setReviewId(review.getReviewId());
                    reviewDTO.setReservationTime(review.getReservation().getReservationTime());
                    Reservation reservation = review.getReservation();

                    if (reservation != null) {

                        // 예약 정보에서 유저 정보 설정 (null이 아닌 경우만 설정)
                        User user = reservation.getUserId();
                        if (user != null) {
                            reviewDTO.setUserId(user.getUserId()); // 유저 아이디
                            reviewDTO.setUserName(user.getUserName()); // 유저 이름
                        }

                        // 예약 정보에서 병원 정보 설정 (null이 아닌 경우만 설정)
                        Hospital hospital = reservation.getHosId();
                        if (hospital != null) {
                            reviewDTO.setHosName(hospital.getName()); // 병원 이름
                            reviewDTO.setAddress(hospital.getAddress());
                        }

                        // 예약 정보에서 진료 유형 설정 (null이 아닌 경우만 설정)
                        ClinicType clinicType = reservation.getClinicType();
                        if (clinicType != null) {
                            reviewDTO.setClinicName(clinicType.getClinicName()); // 진료 유형 이름
                        }

                    }
                    return reviewDTO;
                })
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

        reviewDTO.setUserId(review.getReservation().getUserId().getUserId());
        reviewDTO.setUserName(review.getReservation().getUserId().getUserName());
        reviewDTO.setClinicName(review.getReservation().getClinicType().getClinicName());

        reviewDTO.setHosId(review.getReservation().getHosId().getHosId());
        reviewDTO.setHosName(review.getReservation().getHosId().getName());

        return reviewDTO;

    }

    // 병원 아이디로 해당 리뷰 조회
    public List<ReviewDTO> findReviewByHosId(int hosId) {
        List<Review> foundReviews = reviewRepository.findReviewsByHosId(hosId);

        return foundReviews.stream()
                .map(review -> {
                    ReviewDTO reviewDTO = new ReviewDTO();
                    reviewDTO.setReviewId(review.getReviewId());
                    reviewDTO.setContent(review.getContent());
                    reviewDTO.setReportState(review.getReportState());
                    reviewDTO.setCreatedDate(review.getCreatedDate());
                    reviewDTO.setLastModifiedDate(review.getLastModifiedDate());
                    reviewDTO.setReservationId(review.getReservation().getReservationId());
                    reviewDTO.setUserId(review.getReservation().getUserId().getUserId());
                    reviewDTO.setUserName(review.getReservation().getUserId().getUserName());
                    reviewDTO.setClinicName(review.getReservation().getClinicType().getClinicName());
                    reviewDTO.setHosName(review.getReservation().getHosId().getName());
                    return reviewDTO;
                }).collect(Collectors.toList());
    }

    // 사용자 아이디로 해당 리뷰 조회
    public List<ReviewDTO> findReviewByUserId(String userId) {
        List<Review> foundReviews = reviewRepository.findReviewsByUserId(userId);

        return foundReviews.stream()
                .map(review -> {
                    ReviewDTO reviewDTO = new ReviewDTO();
                    reviewDTO.setReviewId(review.getReviewId());
                    reviewDTO.setContent(review.getContent());
                    reviewDTO.setReportState(review.getReportState());
                    reviewDTO.setCreatedDate(review.getCreatedDate());
                    reviewDTO.setLastModifiedDate(review.getLastModifiedDate());
                    reviewDTO.setReservationId(review.getReservation().getReservationId());
                    reviewDTO.setUserId(review.getReservation().getUserId().getUserId());
                    reviewDTO.setUserName(review.getReservation().getUserId().getUserName());
                    reviewDTO.setClinicName(review.getReservation().getClinicType().getClinicName());
                    reviewDTO.setHosName(review.getReservation().getHosId().getName());
                    return reviewDTO;
                }).collect(Collectors.toList());
    }

    // 리뷰 등록
    public Review createReview(CreateReviewDTO createReviewDTO, int reservationId) {
        // Reservation을 먼저 조회
        Reservation reservation = reservationsRepository.findById(reservationId)
                .orElseThrow(() -> new EntityNotFoundException("해당 예약을 찾을 수 없습니다."));

        boolean badContent = false;

        // 후기 내용에 부적절한 단어가 포함되어 있으면 클린봇 제재
        for (String word : inappropriateWords) {
            if (createReviewDTO.getContent().contains(word)) {
                badContent = true;
                break;
            }
        }

        if (badContent) {
            Review review = Review.builder()
                    .reservation(reservation)
                    .content("\uD83D\uDCF5해당 후기는 클린봇에 의해 가려진 게시글입니다.\uD83D\uDCF5\uD83D\uDCA8")
                    .build();

            return reviewRepository.save(review);
        } else {
            // Review 엔티티 생성 및 값 설정
            Review review = new Review();
            review.setReservation(reservation);  // Review와 Reservation 연결
            review.setContent(createReviewDTO.getContent());

            // Review 저장 (이때 reviewId는 reservationId와 동일하게 설정됨)
            return reviewRepository.save(review);
        }
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
