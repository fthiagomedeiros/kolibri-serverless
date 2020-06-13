package com.serverless.routes.request;

import lombok.Data;
import lombok.NoArgsConstructor;

public @Data
@NoArgsConstructor
class CreateRouteRequest {
    private String date;
    private String flightId;
    private String origin;
    private String destination;
    private int cargo;
    private String airline;
}
