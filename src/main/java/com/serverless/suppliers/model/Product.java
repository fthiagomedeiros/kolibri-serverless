package com.serverless.suppliers.model;

import lombok.Data;
import lombok.NoArgsConstructor;

public @Data
@NoArgsConstructor
class Product {
    private String uuid;
    private String date;
    private String time;
    private String flightId;
    private String origin;
    private String destination;
    private int cargo;
    private String airline;
}
