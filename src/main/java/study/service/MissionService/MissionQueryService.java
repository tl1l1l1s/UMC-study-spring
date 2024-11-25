package study.service.MissionService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import study.domain.Mission;
import study.domain.enums.MissionStatus;
import java.util.Optional;

public interface MissionQueryService {
    Optional<Mission> findByMemberId(Long memberId);

    Page<Mission> findByMemberIdAndStatus(Long memberId, MissionStatus status, Long lastMissionId, Pageable pageable);

    Page<Mission> findChallengingByRegion(Long memberId, Long regionId, Long lastMissionId, Pageable pageable);

    Page<Mission> getMissionListByStoreId(Long storeId, Integer page);

    Page<Mission> getChallengingMissionList(Long memberId, Integer page);
}
