package study.repository.ReviewRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import study.domain.Member;
import study.domain.QReview;
import study.domain.Review;
import study.domain.Store;

@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepositoryCustom{
    private final JPAQueryFactory jpaQueryFactory;
    private final EntityManager entityManager;
    private final QReview review = QReview.review;

    @Override
    public void addReview(Long memberId, Long storeId, String title, String body, Float score) {
//        entityManager
//                .createNativeQuery("INSERT INTO review (member, store, title, body, score) VALUES (?, ?, ?, ?, ?)")
//                .setParameter(1, review.getMember())
//                .setParameter(2, review.getStore())
//                .setParameter(3, review.getTitle())
//                .setParameter(4, review.getBody())
//                .setParameter(5, review.getScore())
//                .executeUpdate();

        Member member = entityManager.find(Member.class, memberId);
        Store store = entityManager.find(Store.class, storeId);

        jpaQueryFactory.insert(review)
                .columns(review.member, review.store, review.title, review.body, review.score)
                .values(member, store, title, body, score)
                .execute();
    }
}
