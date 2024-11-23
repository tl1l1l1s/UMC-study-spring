package study.service.StoreService;

import study.domain.Store;
import study.web.dto.Store.StoreRequestDTO;

public interface StoreCommandService {

    public Store addStore(StoreRequestDTO.AddStoreDTO request);
}
