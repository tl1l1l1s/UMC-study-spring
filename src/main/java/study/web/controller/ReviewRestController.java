package study.web.controller;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import study.apiPayload.ApiResponse;
import study.converter.ReviewConverter;
import study.domain.Review;
import study.service.ReviewService.ReviewCommandService;
import study.web.dto.Review.ReviewRequestDTO;
import study.web.dto.Review.ReviewResponseDTO;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/reviews")
@Tag(name="Review", description = "리뷰 API")
public class ReviewRestController {
    private final ReviewCommandService reviewCommandService;

    @PostMapping(value = "/", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ApiResponse<ReviewResponseDTO.AddReviewResultDTO> addReview(
            @Parameter(content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE))
            @RequestPart("request") @Valid ReviewRequestDTO.AddReviewDTO request,
            @RequestPart("reviewPicture")@Valid MultipartFile reviewPicture
    ) {
        Review review = reviewCommandService.addReview(request, reviewPicture);

        return ApiResponse.onSuccess(ReviewConverter.toAddReviewResultDTO(review));
    }
}
