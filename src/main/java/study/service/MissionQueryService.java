package study.service;

import study.domain.enums.MemberStatus;
import study.domain.mapping.MemberMission;

import java.util.List;
import java.util.Optional;

public interface MissionQueryService {
    Optional<MemberMission> findByMemberId(Long memberId);
    List<MemberMission> findByMemberIdAndStatus(Long memberId, MemberStatus status);
}
