package study.repository.MemberRepository;

import study.domain.Member;

public interface MemberRepositoryCustom {
    Member findMemberProfile(Long memberId);
}
