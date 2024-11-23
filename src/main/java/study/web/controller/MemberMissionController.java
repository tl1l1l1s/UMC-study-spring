package study.web.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.apiPayload.ApiResponse;
import study.converter.MemberMissionConverter;
import study.domain.mapping.MemberMission;
import study.service.MemberMissionService.MemberMissionCommandService;
import study.web.dto.MemberMission.MemberMissionRequestDTO;
import study.web.dto.MemberMission.MemberMissionResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/memberMissions")
public class MemberMissionController {

    private final MemberMissionCommandService memberMissionCommandService;

    @PostMapping("/storeId")
    public ApiResponse<MemberMissionResponseDTO.AddChallengingMissionDTO> addChallengingMission(@RequestBody @Valid MemberMissionRequestDTO.AddChallengingMissionDTO request) {
        MemberMission memMi = memberMissionCommandService.addChallengingMission(request);

        return ApiResponse.onSuccess(MemberMissionConverter.toAddChallengingMissionDTO(memMi));
    }
}
