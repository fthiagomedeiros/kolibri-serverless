package com.serverless.routes.response;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
public @Data @NoArgsConstructor
class CreateRouteResponseError {
    private int code;
    private String message;

    public CreateRouteResponseError(int code, String message) {
        this.code = code;
        this.message = message;
    }

}
