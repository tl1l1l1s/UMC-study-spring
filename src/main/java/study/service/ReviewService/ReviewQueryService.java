package study.service.ReviewService;

import org.springframework.data.domain.Page;
import study.domain.Review;

import java.util.Optional;

public interface ReviewQueryService {
    void insertReview(Long memberId, Long storeId, String title, String body, Float score);

    Page<Review> getReviewList(Long storeId, Integer page);

    Page<Review> getReviewListByMemberId(Long memberId, Integer page);
}
