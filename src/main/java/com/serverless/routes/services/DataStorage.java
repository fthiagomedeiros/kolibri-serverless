package com.serverless.routes.services;

import com.serverless.routes.exceptions.AirlineNotFoundException;
import com.serverless.routes.model.Route;

import java.sql.SQLException;
import java.util.List;

public interface DataStorage {
    Route save(Route route) throws SQLException;
    List<Route> getRoutes(String airline) throws AirlineNotFoundException, SQLException;

}
