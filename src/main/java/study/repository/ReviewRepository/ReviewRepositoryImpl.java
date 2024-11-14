package study.repository.ReviewRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import study.domain.*;

@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepositoryCustom{
    private final JPAQueryFactory jpaQueryFactory;
    private final EntityManager entityManager;
    private final QReview review = QReview.review;
    private final QMember member = QMember.member;
    private final QStore store = QStore.store;

    @Override
    public void addReview(Long memberId, Long storeId, String title, String body, Float score) {
        Member mem = entityManager.find(Member.class, memberId);
        Store str = entityManager.find(Store.class, storeId);

        Review rev = Review.builder()
                .member(mem)
                .store(str)
                .title(title)
                .body(body)
                .score(score)
                .build();

        entityManager.persist(rev);
    }
}
