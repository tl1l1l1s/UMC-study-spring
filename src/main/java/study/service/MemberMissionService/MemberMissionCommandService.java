package study.service.MemberMissionService;

import study.domain.mapping.MemberMission;
import study.web.dto.MemberMission.MemberMissionRequestDTO;

public interface MemberMissionCommandService {

    public MemberMission addChallengingMission(MemberMissionRequestDTO.AddChallengingMissionDTO request);
}
