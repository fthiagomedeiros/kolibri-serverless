package com.serverless.routes.services;

import com.serverless.routes.exceptions.AirlineNotFoundException;
import com.serverless.routes.model.Route;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RdsStorage implements DataStorage {

    private static final Logger LOG = LogManager.getLogger(RdsStorage.class);

    String host = System.getenv("HOST");
    String username = System.getenv("USERNAME");
    String password = System.getenv("PASSWORD");

    private static Connection conn;
    private static Statement stmt;

    public RdsStorage() {
        try {
            conn = DriverManager.getConnection(host, username, password);
            stmt = conn.createStatement();
        } catch (SQLException throwables) {
            LOG.info("Route Created: {}", "throwables.printStackTrace()");
            throwables.printStackTrace();
        }
    }

    @Override
    public Route save(Route route) throws SQLException {
        String insertRoute = String.format("INSERT INTO routes VALUES ('%s', '%s', '%s', '%s', '%s', '%s', %d, '%s')",
                route.getUuid(), route.getDate(), route.getTime(), route.getFlightId(),
                route.getOrigin(), route.getDestination(), route.getCargo(), route.getAirline());
        stmt.executeUpdate(insertRoute);
        return route;
    }

    @Override
    public List<Route> getRoutes() throws SQLException {
        ResultSet resultSet = stmt.executeQuery("SELECT * FROM routes");
        return getRoutes(resultSet);
    }

    @Override
    public List<Route> getRoutes(String airline) throws SQLException {
        ResultSet resultSet = stmt.executeQuery(String.format("SELECT * FROM routes WHERE airline = '%s'", airline));

        return getRoutes(resultSet);
    }

    private List<Route> getRoutes(ResultSet resultSet) throws SQLException {
        List<Route> result = new ArrayList<>();
        while ( resultSet.next() ) {
            String uuid = resultSet.getString("uuid");
            String date = resultSet.getString("date");
            String time = resultSet.getString("time");
            String flightId = resultSet.getString("flightId");
            String origin = resultSet.getString("origin");
            String destination = resultSet.getString("destination");
            String airline = resultSet.getString("airline");
            int cargo = resultSet.getInt("cargo");

            Route r = new Route(uuid, date, time, flightId, origin, destination, cargo, airline);
            result.add(r);
        }

        return result;
    }

}
