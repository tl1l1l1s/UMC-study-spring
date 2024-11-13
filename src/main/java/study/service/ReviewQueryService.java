package study.service;

import study.domain.Review;

import java.util.Optional;

public interface ReviewQueryService {
    Optional<Review> findReview(Long id);
}
