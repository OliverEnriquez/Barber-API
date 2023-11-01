package com.example.barbershop.service;

import com.example.barbershop.domain.Barber;
import com.example.barbershop.domain.Customer;
import com.example.barbershop.domain.Review;
import com.example.barbershop.dto.ReviewDto;
import com.example.barbershop.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    ReviewRepository reviewRepository;
    @Autowired
    BarberService barberService;

    @Autowired
    CustomerService customerService;

    @Autowired
    ServiceBarberService serviceBarberService;

    @Override
    public List<Review> findAllReview() {
        return reviewRepository.findAll();
    }

    @Override
    public Optional<Review> getReviewById(Long id) {
        return reviewRepository.findById(id);
    }

    @Override
    public void addReview(ReviewDto dto) {
        reviewRepository.save(buildReview(dto));
    }

    @Override
    public void updateReview(ReviewDto dto) {
        reviewRepository.save(buildReview(dto));
    }

    @Override
    public void deleteReview(Long id) {
        reviewRepository.deleteById(id);
    }

    private Review buildReview(ReviewDto dto) {
        Review review = new Review();

        if(dto.getReviewId() != null) {
            review.setReviewId(dto.getReviewId());
        }

        Optional<Customer> customer = customerService.findCustomerById(dto.getCustomerId());
        Optional<Barber> barber = barberService.findBarberById(dto.getBarberId());
        Optional<com.example.barbershop.domain.Service> service = serviceBarberService.findServiceById(dto.getServiceId());

        if(barber.isPresent() && customer.isPresent() && service.isPresent()) {
            review.setCustomer(customer.get());
            review.setService(service.get());
            review.setBarber(barber.get());
        }

        review.setComment(dto.getComment());
        review.setRating(dto.getRating());
        review.setReviewDateTime(LocalDateTime.now());
        return review;
    }
}
