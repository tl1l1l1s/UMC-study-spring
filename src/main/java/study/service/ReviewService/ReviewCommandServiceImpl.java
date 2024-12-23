package study.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import study.apiPayload.code.status.ErrorStatus;
import study.apiPayload.exception.handler.MemberHandler;
import study.apiPayload.exception.handler.StoreHandler;
import study.aws.s3.AmazonS3Manager;
import study.converter.ReviewConverter;
import study.domain.Member;
import study.domain.Review;
import study.domain.Store;
import study.domain.Uuid;
import study.repository.MemberRepository.MemberRepository;
import study.repository.ReviewImageRepository.ReviewImageRepository;
import study.repository.ReviewRepository.ReviewRepository;
import study.repository.StoreRepository.StoreRepository;
import study.repository.UuidRepository.UuidRepository;
import study.web.dto.Review.ReviewRequestDTO;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService {

    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;
    private final ReviewImageRepository reviewImageRepository;
    private final AmazonS3Manager s3Manager;
    private final UuidRepository uuidRepository;

    @Override
    public Review addReview(ReviewRequestDTO.AddReviewDTO request, MultipartFile reviewPicture) {
        Review review = ReviewConverter.toReview(request);

        String uuid = UUID.randomUUID().toString();
        Uuid savedUuid = uuidRepository.save(Uuid.builder()
                .uuid(uuid).build());
        String pictureUrl = s3Manager.uploadFile(s3Manager.generateReviewKeyName(savedUuid), reviewPicture);

        Store store = storeRepository.findById(request.getStoreId()).orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));
        Member member = memberRepository.findById(request.getMemberId()).orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));

        review.setMember(member);
        review.setStore(store);

        reviewImageRepository.save(ReviewConverter.toReviewImage(pictureUrl, review));
        return reviewRepository.save(review);
    }
}
