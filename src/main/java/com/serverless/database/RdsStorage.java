package com.serverless.database;

import com.serverless.routes.model.Route;
import com.serverless.suppliers.model.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

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
        String insertRoute = format("INSERT INTO routes VALUES (%s)", route);
        stmt.executeUpdate(insertRoute);
        return route;
    }

    @Override
    public Product save(Product product) throws SQLException {
        String insertRoute = format("INSERT INTO products VALUES (%s)", product);
        stmt.executeUpdate(insertRoute);
        return product;
    }

    @Override
    public List<Route> getRoutes(String airline) throws SQLException {
        ResultSet resultSet = stmt.executeQuery(format("SELECT * FROM routes WHERE airline = '%s'", airline));

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
