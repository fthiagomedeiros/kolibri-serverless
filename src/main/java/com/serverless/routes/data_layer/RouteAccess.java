package com.serverless.routes.data_layer;

import com.serverless.routes.exceptions.AirlineNotFoundException;
import com.serverless.routes.model.Route;

import java.sql.SQLException;
import java.util.List;

public interface RouteAccess {
    Route createRoute(Route route) throws SQLException;
    List<Route> getRoutes() throws SQLException;
    List<Route> getRoutesBy(String airline) throws AirlineNotFoundException, SQLException;
}
