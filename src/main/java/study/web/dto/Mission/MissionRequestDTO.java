package study.web.dto.Mission;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.time.LocalDate;

public class MissionRequestDTO {

    @Getter
    public static class AddMissionDTO{
        @NotNull
        Integer reward;
        LocalDate deadline;
        @Size(min = 1, max = 50)
        String missionSpec;
        @NotNull
        Long storeId;
    }
}
