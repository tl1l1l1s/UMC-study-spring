package study.repository.ReviewRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.domain.Review;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long>, ReviewRepositoryCustom {
//    List<Review> dynamicQueryWithBooleanBuilder
}
