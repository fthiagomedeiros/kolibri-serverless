package com.serverless.suppliers.request;

import lombok.Data;
import lombok.NoArgsConstructor;

public @Data
@NoArgsConstructor
class CreateProductRequest {
    private String type;
    private int quantity;
    private String description;
    private double price;
    private String supplier;
}