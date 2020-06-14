package com.serverless.routes.business_logic;

import com.serverless.routes.model.Route;
import com.serverless.routes.request.CreateRouteRequest;

import java.sql.SQLException;
import java.util.List;

public interface RouteService {
    Route createRoute(CreateRouteRequest route) throws SQLException;
    List<Route> getRoutes();
}
