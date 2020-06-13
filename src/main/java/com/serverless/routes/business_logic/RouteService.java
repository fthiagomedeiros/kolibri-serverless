package com.serverless.routes.business_logic;

import com.serverless.routes.model.Route;
import com.serverless.routes.request.CreateRouteRequest;

public interface RouteService {
    Route createRoute(CreateRouteRequest route);
}
