package study.service.MemberService;

import study.domain.Member;
import study.web.dto.Member.MemberRequestDTO;

public interface MemberCommandService {

    public Member joinMember(MemberRequestDTO.JoinDto request);
}
