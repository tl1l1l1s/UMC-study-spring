package study.converter;

import study.domain.enums.MissionStatus;
import study.domain.mapping.MemberMission;
import study.web.dto.MemberMission.MemberMissionRequestDTO;
import study.web.dto.MemberMission.MemberMissionResponseDTO;

import java.time.LocalDateTime;

public class MemberMissionConverter {

    public static MemberMissionResponseDTO.AddChallengingMissionDTO toAddChallengingMissionDTO(MemberMission memberMission) {

        return MemberMissionResponseDTO.AddChallengingMissionDTO.builder()
                .memberMissionId(memberMission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static MemberMission toMemberMission(MemberMissionRequestDTO.AddChallengingMissionDTO request) {
        return MemberMission.builder()
                .status(MissionStatus.CHALLENGING)
                .build();

    }
}
