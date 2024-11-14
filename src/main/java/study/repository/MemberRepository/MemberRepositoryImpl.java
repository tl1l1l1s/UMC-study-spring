package study.repository.MemberRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import study.domain.Member;
import study.domain.QMember;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    private final QMember qMember = QMember.member;

    @Override
    public Member findMemberProfile(Long memberId) {
        BooleanBuilder predicate = new BooleanBuilder();

        if(memberId != null) {
            predicate.and(qMember.id.eq(memberId));
        }

        return jpaQueryFactory
                .selectFrom(qMember)
                .where(predicate)
                .fetchOne();
    }
}
