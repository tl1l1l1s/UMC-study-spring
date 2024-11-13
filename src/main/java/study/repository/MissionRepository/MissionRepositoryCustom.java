package study.repository.MissionRepository;

import study.domain.enums.MissionStatus;
import study.domain.mapping.MemberMission;

import java.util.List;

public interface MissionRepositoryCustom {
    List<MemberMission> dynamicQueryWithBooleanBuilder(Long memberId, MissionStatus status);
}
