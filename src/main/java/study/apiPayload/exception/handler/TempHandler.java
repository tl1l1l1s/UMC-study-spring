package study.apiPayload.exception.handler;

import study.apiPayload.code.BaseErrorCode;
import study.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode code) {
        super(code);
    }
}
