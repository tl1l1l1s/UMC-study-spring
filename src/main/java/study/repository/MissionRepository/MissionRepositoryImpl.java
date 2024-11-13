package study.repository.MissionRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import study.domain.enums.MissionStatus;
import study.domain.mapping.MemberMission;
import study.domain.mapping.QMemberMission;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MissionRepositoryImpl implements MissionRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    private final QMemberMission memberMission = QMemberMission.memberMission;

    @Override
    public List<MemberMission> dynamicQueryWithBooleanBuilder(Long memberId, MissionStatus status) {
        BooleanBuilder predicate = new BooleanBuilder();

        if(memberId != null) {
            predicate.and(memberMission.id.eq(memberId));
        }

        if(status != null) {
            predicate.and(memberMission.status.eq(status));
        }

        return jpaQueryFactory
                .selectFrom(memberMission)
                .where(predicate)
                .fetch();
    }
}
