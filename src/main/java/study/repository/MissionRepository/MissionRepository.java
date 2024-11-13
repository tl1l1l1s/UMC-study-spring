package study.repository.MissionRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.domain.mapping.MemberMission;

public interface MissionRepository extends JpaRepository<MemberMission, Long>, MissionRepositoryCustom {
}
