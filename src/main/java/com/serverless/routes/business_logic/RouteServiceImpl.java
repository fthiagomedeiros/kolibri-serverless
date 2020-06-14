package com.serverless.routes.business_logic;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.serverless.routes.data_layer.RouteAccess;
import com.serverless.routes.data_layer.RouteAccessImpl;
import com.serverless.routes.model.Route;
import com.serverless.routes.request.CreateRouteRequest;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class RouteServiceImpl implements RouteService {

    private final ObjectMapper mapper = new ObjectMapper();
    private final RouteAccess routeAccess = new RouteAccessImpl();

    @Override
    public Route createRoute(CreateRouteRequest route) throws SQLException {
        Route anNewRoute = mapper.convertValue(route, Route.class);
        anNewRoute.setUuid(UUID.randomUUID().toString());

        return routeAccess.createRoute(anNewRoute);
    }

    @Override
    public List<Route> getRoutes() {
        return routeAccess.getRoutes();
    }

}
