package study.converter;

import study.domain.Review;
import study.domain.Store;
import study.web.dto.Review.ReviewRequestDTO;
import study.web.dto.Review.ReviewResponseDTO;
import study.web.dto.Store.StoreRequestDTO;
import study.web.dto.Store.StoreResponseDTO;

import java.time.LocalDateTime;

public class StoreConverter {

    public static StoreResponseDTO.AddStoreResultDTO addStore(Store store) {

        return StoreResponseDTO.AddStoreResultDTO.builder()
                .storeId(store.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Store toStore(StoreRequestDTO.AddStoreDTO reqeust) {

        return Store.builder()
                .name(reqeust.getName())
                .address(reqeust.getAddress())
                .score(reqeust.getScore())
                .build();
    }
}
