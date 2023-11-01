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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @Autowired
    BarberService barberService;

    @Autowired
    CustomerService customerService;

    @Autowired
    ServiceBarberService serviceBarberService;

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

    @PostMapping(value = "/review")
    public void addReview(@RequestBody ReviewDto dto) {
        Review review = new Review();
        try {
            Optional<Customer> customer = customerService.findCustomerById(dto.getCustomerId());
            Optional<Barber> barber = barberService.findBarberById(dto.getBarberId());
            Optional<Service> service = serviceBarberService.findServiceById(dto.getServiceId());

            if(barber.isPresent() && customer.isPresent() && service.isPresent()) {
                review.setCustomer(customer.get());
                review.setService(service.get());
                review.setBarber(barber.get());
            }

            review.setComment(dto.getComment());
            review.setRating(dto.getRating());
            review.setReviewDateTime(LocalDateTime.now());

            reviewService.addReview(review);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
