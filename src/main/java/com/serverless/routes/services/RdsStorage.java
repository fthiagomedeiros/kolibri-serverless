package com.serverless.routes.services;

import com.serverless.routes.exceptions.AirlineNotFoundException;
import com.serverless.routes.model.Route;

import java.sql.*;
import java.util.List;

public class RdsStorage implements DataStorage {

    private Connection conn;
    private Statement stmt;

    public RdsStorage() {
        try {
            String host = System.getenv("HOST");
            String username = System.getenv("USERNAME");
            String password = System.getenv("PASSWORD");

            this.conn = DriverManager.getConnection(host, username, password);
            this.stmt = conn.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Route save(Route route) throws SQLException {
        String insertRoute = String.format("INSERT INTO routes VALUES ('%s', '%s', '%s', '%s', '%s', %d, '%s')",
                route.getUuid(), route.getDate(), route.getTime(),
                route.getOrigin(), route.getDestination(), route.getCargo(), route.getAirline());
        int resultSet = stmt.executeUpdate(insertRoute);
        return route;
    }

    @Override
    public List<Route> getRoutes() {
        return null;
    }

    @Override
    public List<Route> getRoutes(String airline) throws AirlineNotFoundException {
        return null;
    }

}
