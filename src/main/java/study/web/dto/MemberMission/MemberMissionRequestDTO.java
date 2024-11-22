package study.web.dto.MemberMission;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class MemberMissionRequestDTO {

    @Getter
    public static class AddChallengingMissionDTO {
        @NotNull
        private Long storeId;

        @NotNull
        private Long memberId;
    }
}
