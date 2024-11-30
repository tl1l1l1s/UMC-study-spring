package study.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import study.apiPayload.ApiResponse;
import study.converter.ReviewConverter;
import study.domain.Review;
import study.service.ReviewService.ReviewCommandService;
import study.service.ReviewService.ReviewQueryService;
import study.validation.annotation.ExistStores;
import study.web.dto.Review.ReviewRequestDTO;
import study.web.dto.Review.ReviewResponseDTO;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/reviews")
public class ReviewRestController {
    private final ReviewCommandService reviewCommandService;


    @PostMapping("/")
    public ApiResponse<ReviewResponseDTO.AddReviewResultDTO> addReview(@RequestBody @Valid ReviewRequestDTO.AddReviewDTO request) {
        Review review = reviewCommandService.addReview(request);

        return ApiResponse.onSuccess(ReviewConverter.toAddReviewResultDTO(review));
    }
}
