package com.serverless.routes.services;

import com.serverless.routes.exceptions.AirlineNotFoundException;
import com.serverless.routes.model.Route;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class RdsStorage implements DataStorage {

    private static final Logger LOG = LogManager.getLogger(RdsStorage.class);

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
            LOG.info("Route Created: {}", "throwables.printStackTrace()");
            throwables.printStackTrace();
        }
    }

    @Override
    public Route save(Route route) throws SQLException {
        String insertRoute = String.format("INSERT INTO routes VALUES ('%s', '%s', '%s', '%s', '%s', %d, '%s')",
                route.getUuid(), route.getDate(), route.getTime(),
                route.getOrigin(), route.getDestination(), route.getCargo(), route.getAirline());
        stmt.executeUpdate(insertRoute);
        return route;
    }

    @Override
    public List<Route> getRoutes() {
        LOG.info("Get Worked: {}", "getRoutes()");
        return new ArrayList<>();
    }

    @Override
    public List<Route> getRoutes(String airline) throws AirlineNotFoundException {
        return null;
    }

}
