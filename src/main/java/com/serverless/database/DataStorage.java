package com.serverless.database;

import com.serverless.routes.exceptions.AirlineNotFoundException;
import com.serverless.routes.model.Route;
import com.serverless.suppliers.model.Product;

import java.sql.SQLException;
import java.util.List;

public interface DataStorage {
    Route save(Route route) throws SQLException;
    Product save(Product product) throws SQLException;
    List<Route> getRoutes(String airline) throws AirlineNotFoundException, SQLException;
    List<Product> getProducts(String supplier) throws SQLException;
}
