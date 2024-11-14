package study.repository.MissionRepository;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import study.domain.Mission;
import study.domain.QMission;
import study.domain.QRegion;
import study.domain.QStore;
import study.domain.enums.MissionStatus;
import study.domain.mapping.QMemberMission;

import java.time.LocalDate;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MissionRepositoryImpl implements MissionRepositoryCustom {
    private final JPAQueryFactory jpaQueryFactory;
    private final QMission mission = QMission.mission;
    private final QMemberMission memberMission = QMemberMission.memberMission;
    private final QStore store = QStore.store;
    private final QRegion region = QRegion.region;

    // 진행 중이거나 진행 완료인 미션 모아보기
    @Override
    public Page<Mission> dynamicQueryWithBooleanBuilder(Long memberId, MissionStatus status, Pageable pageable) {
        BooleanBuilder predicate = new BooleanBuilder();

        if(memberId != null) {
            predicate.and(memberMission.id.eq(memberId));
        }

        if(status != null) {
            predicate.and(memberMission.status.eq(status));
        }

        List<Mission> missionList = jpaQueryFactory
            .selectFrom(mission)
            .join(memberMission.mission)
            .where(predicate)
            .offset(pageable.getOffset())
            .limit(pageable.getPageSize())
            .fetch();

        int total = jpaQueryFactory
                .selectFrom(mission)
                .where(predicate)
                .fetch().size();

        return new PageImpl<>(missionList, pageable, total);
    }

    // 현재 선택한 region에서 도전 가능한 미션 모아보기
    @Override
    public Page<Mission> findChallengingMissionByRegion(Long memberId, Long regionId, Pageable pageable) {
        BooleanBuilder predicate = new BooleanBuilder();

        if(memberId != null) {
            predicate.and(memberMission.id.eq(memberId));
            predicate.and(memberMission.status.eq(MissionStatus.CHALLENGING));
            predicate.and(mission.deadline.gt(LocalDate.now()));
        }

        if(regionId != null) {
            predicate.and(region.id.eq(regionId));
        }

        List<Mission> missionList = jpaQueryFactory
                .selectFrom(mission)
                .join(mission.store, store)
                .join(store.region, region)
                .where(predicate)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        int total = jpaQueryFactory
                .selectFrom(mission)
                .join(mission.store, store)
                .join(store.region, region)
                .where(predicate)
                .fetch().size();

        return new PageImpl<>(missionList, pageable, total);
    }
}
