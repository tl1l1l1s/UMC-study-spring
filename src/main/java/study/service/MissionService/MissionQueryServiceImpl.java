package study.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.domain.Member;
import study.domain.Mission;
import study.domain.Store;
import study.domain.enums.MissionStatus;
import study.repository.MemberRepository.MemberRepository;
import study.repository.MissionRepository.MissionRepository;
import study.repository.StoreRepository.StoreRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionQueryServiceImpl implements MissionQueryService {
    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;
    private final MemberRepository memberRepository;

    @Override
    public Optional<Mission> findByMemberId(Long memberId) {
        return missionRepository.findById(memberId);
    }

    @Override
    public Page<Mission> findByMemberIdAndStatus(Long memberId, MissionStatus status, Long lastMissionId, Pageable pageable) {
        Page<Mission> filteredMissions = missionRepository.dynamicQueryWithBooleanBuilder(memberId, status, lastMissionId, pageable);

        filteredMissions.forEach(mission -> {
            System.out.println(status + " : " + mission);
        });

        return filteredMissions;
    }

    @Override
    public Page<Mission> findChallengingByRegion(Long memberId, Long regionId,  Long lastMissionId, Pageable pageable) {
        Page<Mission> filteredMissions = missionRepository.findChallengingMissionByRegion(memberId, regionId, lastMissionId, pageable);

        filteredMissions.forEach(mission -> {
            System.out.println("현재 " + regionId + "의 region에서 실행 가능한 미션들 : " + mission);
        });

        return filteredMissions;
    }

    @Override
    public Page<Mission> getMissionListByStoreId(Long storeId, Integer page) {
        Store store = storeRepository.findById(storeId).get();

        return missionRepository.findAllByStore(store, PageRequest.of(page, 10));
    }

    @Override
    public Page<Mission> getChallengingMissionList(Long memberId, Integer page) {
        Member member = memberRepository.findById(memberId).get();
        Pageable pageable = PageRequest.of(page, 10);
        Long lastMissionId = page > 0 ? (page * 10L) : null;

        return missionRepository.dynamicQueryWithBooleanBuilder(member.getId(), MissionStatus.CHALLENGING, lastMissionId, pageable);
    }
}
