package study.web.dto.Member;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import study.validation.annotation.ExistCategories;

import java.util.List;

public class MemberRequestDTO {

    @Getter
    public static class JoinDto{
        @NotBlank
        String name;
        @NotNull
        Integer gender;
        @Size(min = 5, max = 40)
        String address;
        @Size(min = 5, max = 40)
        String specAddress;
        @ExistCategories
        List<Long> preferCategory;
    }
}