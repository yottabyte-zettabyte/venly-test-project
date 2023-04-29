package com.venly.testproject.exceptions.handler;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessageDTO {

    private ErrorCode errorCode;
    private String errorMsg;

    public ErrorMessageDTO(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
