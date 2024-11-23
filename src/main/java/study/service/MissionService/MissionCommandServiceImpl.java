package study.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import study.apiPayload.code.status.ErrorStatus;
import study.apiPayload.exception.handler.StoreHandler;
import study.converter.MissionConverter;
import study.domain.Mission;
import study.domain.Store;
import study.repository.MissionRepository.MissionRepository;
import study.repository.StoreRepository.StoreRepository;
import study.web.dto.Mission.MissionRequestDTO;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements  MissionCommandService {

    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;

    @Override
    @Transactional
    public Mission addMission(MissionRequestDTO.AddMissionDTO request) {
        Mission mission = MissionConverter.toMission(request);
        Store store = storeRepository.findById(request.getStoreId()).orElseThrow(() -> new StoreHandler(ErrorStatus.STORE_NOT_FOUND));

        mission.setStore(store);
        return missionRepository.save(mission);
    }
}
