package com.rocket.healingpets.reviews.controller;

import com.rocket.healingpets.common.ResponseMessage;
import com.rocket.healingpets.reviews.model.dto.CreateReviewDTO;
import com.rocket.healingpets.reviews.model.dto.ReadReviewDTO;
import com.rocket.healingpets.reviews.model.dto.ReviewDTO;
import com.rocket.healingpets.reviews.model.entity.Review;
import com.rocket.healingpets.reviews.service.ReviewService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/review")
@Slf4j
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;
    private final ModelMapper modelMapper;

    @Operation(summary = "전체 리뷰 조회")
    @GetMapping("")
    public ResponseEntity<ResponseMessage> findAllReview(){
        List<ReadReviewDTO> allReview = reviewService.findAllReview();

        log.info("조회된 전체 리뷰 정보 : {}", allReview);

        Map<String, Object> responsMap = new HashMap<>();
        responsMap.put("review", allReview);

        log.info(responsMap.toString());

        return ResponseEntity.ok()
                .body(new ResponseMessage(
                        HttpStatus.OK,
                        "전체 리뷰 목록",
                        responsMap
                ));
    }

    @Operation(summary = "전체 리뷰 조회(하나씩)")
    @GetMapping("/one")
    public ResponseEntity<ResponseMessage> findAllReview2(){
        List<ReviewDTO> allReview = reviewService.findAllReview2();

        log.info("조회된 전체 리뷰 정보 : {}", allReview);

        Map<String, Object> responsMap = new HashMap<>();
        responsMap.put("review", allReview);

        log.info(responsMap.toString());

        return ResponseEntity.ok()
                .body(new ResponseMessage(
                        HttpStatus.OK,
                        "전체 리뷰 목록",
                        responsMap
                ));
    }

    @Operation(summary = "리뷰 아이디로 해당 리뷰 조회")
    @GetMapping("/{reviewId}")
    public ResponseEntity<ResponseMessage> findReviewById(@PathVariable int reviewId){

        ReviewDTO review = reviewService.findReviewById(String.valueOf(reviewId));

        log.info("조회된 리뷰 정보 : {}", review);

        Map<String, Object> responseMap = new HashMap<>();

        responseMap.put("review", review);

        return ResponseEntity.ok()
                .body(
                        new ResponseMessage(HttpStatus.OK,
                                review + "의 리뷰 정보를 불러옵니다...", responseMap));

    }

    @Operation(summary = "병원 아이디로 리뷰 전체 조회")
    @GetMapping("/hospital/{hosId}")
    public ResponseEntity<ResponseMessage> findReviewByHosId(@PathVariable int hosId){

        List<ReviewDTO> review = reviewService.findReviewByHosId(hosId);

        log.info("조회된 리뷰 정보 : {}", review);

        Map<String, Object> responseMap = new HashMap<>();

        responseMap.put("review", review);

        return ResponseEntity.ok()
                .body(
                        new ResponseMessage(HttpStatus.OK,
                                hosId + "번 병원의 모든 리뷰 정보를 불러옵니다...", responseMap));

    }


    @Operation(summary = "사용자 아이디로 리뷰 전체 조회")
    @GetMapping("/user/{userId}")
    public ResponseEntity<ResponseMessage> findReviewByUserId(@PathVariable String userId){
        List<ReviewDTO> reviewDTO = reviewService.findReviewByUserId(userId);

        log.info("사용자 아이디로 조회된 리뷰 정보 : {}", reviewDTO);

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("reviewDTO", reviewDTO);

        return ResponseEntity.ok().body(
                new ResponseMessage(HttpStatus.OK,
                        userId + "의 리뷰 정보를 불러옵니다...", responseMap));
    }


        // 리뷰 등록(작성)
        @Operation(summary = "리뷰 등록(작성)")
        @PostMapping("")
        public ResponseEntity<ResponseMessage> createReview(@RequestParam int reservationId, @RequestBody CreateReviewDTO createReviewDTO) {
            // Review 생성
            Review Review = reviewService.createReview(createReviewDTO, reservationId);

            ReadReviewDTO createReview = modelMapper.map(Review,ReadReviewDTO.class);

            Map<String, Object> responseMap = new HashMap<>();
            responseMap.put("review", createReview);

            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(new ResponseMessage(HttpStatus.CREATED,
                            "리뷰가 성공적으로 생성되었습니다.", responseMap));
        }

        // 리뷰 수정
        @Operation(summary = "리뷰 수정")
        @PutMapping("/{reviewId}")
        public ResponseEntity<ResponseMessage> modifyReview(@PathVariable int reviewId, @RequestBody CreateReviewDTO reviewDTO) {
            Review Review = reviewService.modifyReview(reviewId, reviewDTO);

            ReadReviewDTO updatedReview = modelMapper.map(Review, ReadReviewDTO.class);

            Map<String, Object> responseMap = new HashMap<>();
            responseMap.put("review", updatedReview);

            return ResponseEntity.ok()
                    .body(new ResponseMessage(HttpStatus.OK, reviewId + "번 리뷰가 수정되었습니다.", responseMap));
        }

        // 리뷰 삭제
        @Operation(summary = "리뷰 삭제")
        @DeleteMapping("/{reviewId}")
        public ResponseEntity<ResponseMessage> deleteReview(@PathVariable int reviewId) {
            reviewService.deleteReview(reviewId);

            return ResponseEntity.ok()
                    .body(new ResponseMessage(HttpStatus.NO_CONTENT, reviewId + "번 리뷰가 삭제되었습니다."));
        }


}
