package study.service.ReviewService;

import study.domain.Review;
import study.web.dto.Review.ReviewRequestDTO;

public interface ReviewCommandService {

    public Review addReview(ReviewRequestDTO.AddReviewDTO request);
}
