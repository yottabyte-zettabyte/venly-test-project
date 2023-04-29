package com.venly.testproject.exceptions;

import com.venly.testproject.exceptions.handler.ErrorCode;

public class NotFoundException extends GenericException {

    public NotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }

    public NotFoundException(ErrorCode errorCode, Object[] args) {
        super(errorCode, args);
    }
}
