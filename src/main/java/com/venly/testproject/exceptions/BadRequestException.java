package com.venly.testproject.exceptions;

import com.venly.testproject.exceptions.handler.ErrorCode;

public class BadRequestException extends GenericException {

    public BadRequestException(ErrorCode errorCode) {
        super(errorCode);
    }

    public BadRequestException(ErrorCode errorCode, Object[] args) {
        super(errorCode, args);
    }

    public BadRequestException(ErrorCode errorCode, Throwable cause) {
        super(errorCode, cause);
    }

    public BadRequestException(ErrorCode errorCode, Throwable cause, Object[] args) {
        super(errorCode, cause, args);
    }
}
