package study.web.dto.Store;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

public class StoreRequestDTO {

    @Getter
    public static class AddStoreDTO {
        @Size(min=1, max=20)
        private String name;

        @Size(min=1, max=80)
        private String address;

        private Float score;

        private Long regionId;
    }
}
