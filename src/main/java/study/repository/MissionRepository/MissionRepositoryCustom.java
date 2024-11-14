package study.repository.MissionRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import study.domain.Mission;
import study.domain.enums.MissionStatus;

public interface MissionRepositoryCustom {
    Page<Mission> dynamicQueryWithBooleanBuilder(Long memberId, MissionStatus status, Pageable pageable);

    Page<Mission> findChallengingMissionByRegion(Long memberId, Long regionId, Pageable pageable);
}
