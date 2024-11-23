package study.service.MemberMissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import study.apiPayload.code.status.ErrorStatus;
import study.apiPayload.exception.handler.MemberHandler;
import study.converter.MemberMissionConverter;
import study.domain.Member;
import study.domain.Mission;
import study.domain.mapping.MemberMission;
import study.repository.MemberMission.MemberMissionRepository;
import study.repository.MemberRepository.MemberRepository;
import study.repository.MissionRepository.MissionRepository;
import study.web.dto.MemberMission.MemberMissionRequestDTO;

@Service
@RequiredArgsConstructor
public class MemberMissionCommandServiceImpl implements MemberMissionCommandService {

    private final MemberMissionRepository memberMissionRepository;
    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;


    @Override
    public MemberMission addChallengingMission(MemberMissionRequestDTO.AddChallengingMissionDTO request) {
        MemberMission memMi = MemberMissionConverter.toMemberMission(request);

        Member member = memberRepository.findById(request.getMemberId()).orElseThrow(() -> new MemberHandler(ErrorStatus.MEMBER_NOT_FOUND));
        Mission mission = missionRepository.findByStoreId(request.getStoreId());

        memMi.setMission(mission);
        memMi.setMember(member);
        return memberMissionRepository.save(memMi);
    }
}
