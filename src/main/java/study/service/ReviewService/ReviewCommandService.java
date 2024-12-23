package study.service.ReviewService;

import org.springframework.web.multipart.MultipartFile;
import study.domain.Review;
import study.web.dto.Review.ReviewRequestDTO;

public interface ReviewCommandService {

    public Review addReview(ReviewRequestDTO.AddReviewDTO request, MultipartFile reviewPicture);
}
