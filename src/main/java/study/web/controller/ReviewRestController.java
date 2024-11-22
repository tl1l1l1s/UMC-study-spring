package study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.apiPayload.ApiResponse;
import study.converter.ReviewConverter;
import study.domain.Review;
import study.service.ReviewService.ReviewCommandService;
import study.service.ReviewService.ReviewQueryService;
import study.web.dto.Review.ReviewRequestDTO;
import study.web.dto.Review.ReviewResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewRestController {
    private final ReviewCommandService reviewCommandService;

    @PostMapping("/")
    public ApiResponse<ReviewResponseDTO.AddReviewResultDTO> addReview(@RequestBody @Valid ReviewRequestDTO.AddReviewDTO request) {
        Review review = reviewCommandService.addReview(request);

        return ApiResponse.onSuccess(ReviewConverter.toAddReviewResultDTO(review));
    }
}
