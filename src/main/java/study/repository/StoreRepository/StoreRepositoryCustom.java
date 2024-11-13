package study.repository.StoreRepository;

import study.domain.Store;
import java.util.List;

public interface StoreRepositoryCustom {
    List<Store> dynamicQueryWithBooleanBuilder(String name, Float score);
}
