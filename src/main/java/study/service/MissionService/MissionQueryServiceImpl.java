package study.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.domain.Mission;
import study.domain.enums.MissionStatus;
import study.repository.MissionRepository.MissionRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionQueryServiceImpl implements MissionQueryService {
    private final MissionRepository missionRepository;

    @Override
    public Optional<Mission> findByMemberId(Long memberId) {
        return missionRepository.findById(memberId);
    }

    @Override
    public Page<Mission> findByMemberIdAndStatus(Long memberId, MissionStatus status, Pageable pageable) {
        Page<Mission> filteredMissions = missionRepository.dynamicQueryWithBooleanBuilder(memberId, status, pageable);

        filteredMissions.forEach(mission -> {
            System.out.println(status + " : " + mission);
        });

        return filteredMissions;
    }

    @Override
    public Page<Mission> findChallengingByRegion(Long memberId, Long regionId, Pageable pageable) {
        Page<Mission> filteredMissions = missionRepository.findChallengingMissionByRegion(memberId, regionId, pageable);

        filteredMissions.forEach(mission -> {
            System.out.println("현재 " + regionId + "의 region에서 실행 가능한 미션들 : " + mission);
        });

        return filteredMissions;
    }
}
