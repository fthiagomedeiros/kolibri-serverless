package com.serverless.routes.model;

import lombok.Data;
import lombok.NoArgsConstructor;

public @Data
@NoArgsConstructor
class Route {
    private String uuid;
    private String date;
    private String time;
    private String flightId;
    private String origin;
    private String destination;
    private int cargo;
    private String airline;

    public Route(String uuid, String date, String time, String flightId, String origin, String destination, int cargo, String airline) {
        this.uuid = uuid;
        this.date = date;
        this.time = time;
        this.flightId = flightId;
        this.origin = origin;
        this.destination = destination;
        this.cargo = cargo;
        this.airline = airline;
    }

    public String toString() {
        return String.format("'%s', '%s', '%s', '%s', '%s', '%s', %s, '%s'", getUuid(), getDate(), getTime(),
                getFlightId(), getOrigin(), getDestination(), getCargo(), getAirline());
    }

}
