package com.example.barbershop.controller;

import com.example.barbershop.domain.Barber;
import com.example.barbershop.domain.Customer;
import com.example.barbershop.domain.Review;
import com.example.barbershop.domain.Service;
import com.example.barbershop.dto.ReviewDto;
import com.example.barbershop.service.BarberService;
import com.example.barbershop.service.CustomerService;
import com.example.barbershop.service.ReviewService;
import com.example.barbershop.service.ServiceBarberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @GetMapping(value = "/reviews")
    public List<Review> findAllReviews() {
        List<Review> reviews = new ArrayList<>();
        try {
            reviews = reviewService.findAllReview();
            return  reviews;
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }

    @GetMapping(value = "/review/{id}")
    public Optional<Review> getReviewId(@PathVariable("id") Long id) {
        return reviewService.getReviewById(id);
    }

    @PostMapping(value = "/review")
    public void addReview(@RequestBody ReviewDto dto) {
        try {
            reviewService.addReview(dto);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @PutMapping(value = "/review")
    public void updateReview(@RequestBody ReviewDto dto) {
        try {
            reviewService.addReview(dto);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @DeleteMapping(value = "/review/{id}")
    public void deleteReview(@PathVariable("id") Long id) {
        reviewService.deleteReview(id);
    }
}
