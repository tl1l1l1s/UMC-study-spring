package study.service.ReviewService;

import study.domain.Review;

import java.util.Optional;

public interface ReviewQueryService {
    void insertReview(Long memberId, Long storeId, String title, String body, Float score);
}
