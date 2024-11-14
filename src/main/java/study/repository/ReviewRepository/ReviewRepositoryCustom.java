package study.repository.ReviewRepository;

import study.domain.Review;

public interface ReviewRepositoryCustom{
    void addReview(Long memberId, Long storeId, String title, String body, Float score);
}
