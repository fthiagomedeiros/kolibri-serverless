package com.serverless.routes.services;

import com.serverless.routes.model.Route;

import java.util.List;

public interface DataStorage {
    Route save(Route route);
    List<Route> getRoutes();
}
