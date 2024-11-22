package study.repository.RegionRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.domain.Region;

public interface RegionRepository  extends JpaRepository<Region, Long> {
}
