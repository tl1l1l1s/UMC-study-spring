package study.service.StoreService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import study.converter.StoreConverter;
import study.domain.Region;
import study.domain.Store;
import study.repository.RegionRepository.RegionRepository;
import study.repository.StoreRepository.StoreRepository;
import study.web.dto.Store.StoreRequestDTO;

@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService {

    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;

    @Override
    public Store addStore(StoreRequestDTO.AddStoreDTO request) {
        Store store = StoreConverter.toStore(request);
        Region region = regionRepository.findById(request.getRegionId()).orElse(null);

        store.setRegion(region);
        return storeRepository.save(store);
    }
}
