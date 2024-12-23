package study.repository.UuidRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.domain.Uuid;

public interface UuidRepository extends JpaRepository<Uuid, Long> {
}
