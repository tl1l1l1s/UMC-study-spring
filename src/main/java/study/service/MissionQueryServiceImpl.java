//package study.service;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import study.domain.enums.MemberStatus;
//import study.domain.enums.MissionStatus;
//import study.domain.mapping.MemberMission;
//import study.repository.MissionRepository.MissionRepository;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//@RequiredArgsConstructor
//@Transactional(readOnly = true)
//public class MissionQueryServiceImpl implements MissionQueryService {
//    private final MissionRepository missionRepository;
//
//    @Override
//    public Optional<MemberMission> findByMemberId(Long memberId) {
//        return missionRepository.findById(memberId);
//    }
//
//    @Override
//    public List<MemberMission> findByMemberIdAndStatus(Long memberId, MissionStatus status) {
//        List<MemberMission> filteredMissions = missionRepository.dynamicQueryWithBooleanBuilder(memberId, status);
//
//        return filteredMissions;
//    }
//}
