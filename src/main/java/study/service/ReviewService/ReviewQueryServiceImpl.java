package study.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.domain.Member;
import study.domain.Review;
import study.domain.Store;
import study.repository.MemberRepository.MemberRepository;
import study.repository.ReviewRepository.ReviewRepository;
import study.repository.StoreRepository.StoreRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class ReviewQueryServiceImpl implements ReviewQueryService {
    private final ReviewRepository reviewRepository;
    private final StoreRepository storeRepository;
    private final MemberRepository memberRepository;

    @Override
    public void insertReview(Long memberId, Long storeId, String title, String body, Float score) {
        reviewRepository.addReview(memberId, storeId, title, body, score);
    }

    @Override
    public Page<Review> getReviewList(Long storeId, Integer page) {
        Store store = storeRepository.findById(storeId).get();

        return reviewRepository.findAllByStore(store, PageRequest.of(page, 10));
    }

    @Override
    public Page<Review> getReviewListByMemberId(Long memberId, Integer page) {
        Member member = memberRepository.findById(memberId).get();

        return reviewRepository.findAllByMember(member, PageRequest.of(page, 10));
    }
}
