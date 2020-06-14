package com.serverless.routes.data_layer;

import com.serverless.routes.model.Route;

import java.sql.SQLException;
import java.util.List;

public interface RouteAccess {
    Route createRoute(Route route) throws SQLException;
    List<Route> getRoutes() throws SQLException;
}
