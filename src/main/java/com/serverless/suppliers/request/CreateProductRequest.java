package com.serverless.suppliers.request;

import lombok.Data;
import lombok.NoArgsConstructor;

public @Data
@NoArgsConstructor
class CreateProductRequest {
    private String type;
    private String quantity;
    private String description;
}
