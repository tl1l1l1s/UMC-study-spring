package study.web.dto.Review;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

public class ReviewRequestDTO {

    @Getter
    public static class AddReviewDTO {
        @NotNull
        private Long memberId;

        @Size(min=1, max=20)
        private String title;

        @Size(min=1, max=300)
        private String body;

        private Float score;

        @NotNull
        private Long storeId;
    }
}
