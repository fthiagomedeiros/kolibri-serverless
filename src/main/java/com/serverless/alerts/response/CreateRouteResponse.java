package com.serverless.routes.response;

import lombok.Data;
import lombok.NoArgsConstructor;

public @Data
@NoArgsConstructor
class CreateRouteResponse {
    private String uuid;
    private String date;
    private String flightId;
    private String origin;
    private String destination;
    private int cargo;
    private String airline;
}
