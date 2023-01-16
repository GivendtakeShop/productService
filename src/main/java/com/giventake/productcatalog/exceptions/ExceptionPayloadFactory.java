package com.giventake.productcatalog.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ExceptionPayloadFactory {

    // Technical Exception
    TECHNICAL_ERROR(0, HttpStatus.INTERNAL_SERVER_ERROR, "technical.error"),

    // Business Exception
    INVALID_PAYLOAD(1, HttpStatus.BAD_REQUEST, "invalid.request.payload"),

    PRODUCT_NOT_FOUND(2, HttpStatus.NOT_FOUND, "product.not.found"),

    REQUIRED_FIELD(3, HttpStatus.BAD_REQUEST, "required.field"),

    UNKOWN_VALUE(4, HttpStatus.BAD_REQUEST, "unkown.value"),

    MIN_VALUE(5, HttpStatus.BAD_REQUEST, "min.value"),

    SIZE_LIMIT_EXCEEDED(6, HttpStatus.BAD_REQUEST,"size.limit.exceeded");




    private final Integer code;
    private final HttpStatus status;
    private final String message;

    public ExceptionPayload get() {
        return new ExceptionPayload(code, status, message);
    }

}
