package study.repository.FoodCategoryRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.domain.FoodCategory;

public interface FoodCategoryRepository extends JpaRepository<FoodCategory, Long> {
}
