package study.service.MemberService;

import study.domain.Member;

public interface MemberQueryService {
    Member getMemberProfileById(Long memberId);
}
