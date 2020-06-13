package com.serverless.routes.data_layer;

import com.serverless.routes.model.Route;

public interface RouteAccess {
    Route createRoute(Route route);
}
