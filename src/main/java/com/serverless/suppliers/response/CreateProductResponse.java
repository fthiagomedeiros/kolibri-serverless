package com.serverless.suppliers.response;

import lombok.Data;
import lombok.NoArgsConstructor;

public @Data
@NoArgsConstructor
class CreateProductResponse {
    private String uuid;
    private String type;
    private String quantity;
    private String description;
}
