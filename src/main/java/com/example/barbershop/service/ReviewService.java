package com.example.barbershop.service;

import com.example.barbershop.domain.Review;

import java.util.List;

public interface ReviewService {
    List<Review> findAllReview();

    void addReview(Review review);
}
