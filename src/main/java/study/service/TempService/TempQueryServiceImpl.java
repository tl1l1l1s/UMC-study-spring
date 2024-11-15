package study.service.TempService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import study.apiPayload.code.status.ErrorStatus;
import study.apiPayload.exception.handler.TempHandler;

@Service
@RequiredArgsConstructor
public class TempQueryServiceImpl implements TempQueryService {

    @Override
    public void CheckFlag(Integer flag) {
        if(flag == 1)
            throw new TempHandler(ErrorStatus.TEMP_EXCEPTION);
    }
}
