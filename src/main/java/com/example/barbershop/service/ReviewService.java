package com.example.barbershop.service;

import com.example.barbershop.domain.Review;
import com.example.barbershop.dto.ReviewDto;

import java.util.List;
import java.util.Optional;

public interface ReviewService {
    List<Review> findAllReview();

    Optional<Review> getReviewById(Long id);

    void addReview(ReviewDto dto);

    void updateReview(ReviewDto dto);

    void deleteReview(Long id);
}
