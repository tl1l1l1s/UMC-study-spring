package study.service.MissionService;

import study.domain.Mission;
import study.web.dto.Mission.MissionRequestDTO;

public interface MissionCommandService {

    public Mission addMission(MissionRequestDTO.AddMissionDTO request);
}
