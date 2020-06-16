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
    private double price;
    private String supplier;

    public String toString() {
        return String.format("'%s', '%s', %s, %.2f, '%s', '%s'",
                getUuid(), getType(), getQuantity(),
                getPrice(), getDescription(), getSupplier());
    }
}
