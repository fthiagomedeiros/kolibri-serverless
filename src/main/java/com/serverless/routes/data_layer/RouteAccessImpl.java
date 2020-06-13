package com.serverless.routes.data_layer;

import com.serverless.routes.model.Route;
import com.serverless.routes.services.DataStorage;
import com.serverless.routes.services.MemoryStorage;

public class RouteAccessImpl implements RouteAccess {

    private final DataStorage repository = new MemoryStorage();

    @Override
    public Route createRoute(Route route) {
        return repository.save(route);
    }

}
