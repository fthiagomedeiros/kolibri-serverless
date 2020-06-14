package com.serverless.routes.data_layer;

import com.serverless.routes.model.Route;
import com.serverless.routes.services.DataStorage;
import com.serverless.routes.services.RdsStorage;

import java.sql.SQLException;
import java.util.List;

public class RouteAccessImpl implements RouteAccess {

    private static final DataStorage repository = new RdsStorage();

    @Override
    public Route createRoute(Route route) throws SQLException {
        return repository.save(route);
    }

    @Override
    public List<Route> getRoutes() {
        return repository.getRoutes();
    }

}
