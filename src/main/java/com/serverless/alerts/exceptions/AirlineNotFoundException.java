package com.serverless.routes.exceptions;

public class AirlineNotFoundException extends Throwable {
    public AirlineNotFoundException(String airline) {
        super(airline);
    }
}
