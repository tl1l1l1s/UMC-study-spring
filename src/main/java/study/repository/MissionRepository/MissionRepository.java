package study.repository.MissionRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import study.domain.Member;
import study.domain.Mission;
import study.domain.Store;
import study.domain.enums.MissionStatus;

public interface MissionRepository extends JpaRepository<Mission, Long>, MissionRepositoryCustom {

    Page<Mission> findAllByStore(Store store, PageRequest pageRequest);
}
