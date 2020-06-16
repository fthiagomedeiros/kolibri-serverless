package com.serverless.suppliers.model;

import lombok.Data;
import lombok.NoArgsConstructor;

public @Data
@NoArgsConstructor
class Product {
    private String uuid;
    private String type;
    private int quantity;
    private String description;
    private String supplier;
}
