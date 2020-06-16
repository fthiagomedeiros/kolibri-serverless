package com.serverless.database;

import com.serverless.routes.exceptions.AirlineNotFoundException;
import com.serverless.routes.model.Route;
import com.serverless.suppliers.model.Product;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryStorage implements DataStorage {

    private static final List<Route> routes = new ArrayList<>();
    private static final Map<String, List<Route>> routesFromAirline = new HashMap<>();

    private static final List<Product> products = new ArrayList<>();
    private static final Map<String, List<Product>> suppliers = new HashMap<>();

    @Override
    public Route save(Route route) {
        routes.add(route);

        if (routesFromAirline.containsKey(route.getAirline())) {
            routesFromAirline.get(route.getAirline()).add(route);
        } else {
            List<Route> newRoutesForAirline = new ArrayList<>();
            newRoutesForAirline.add(route);
            routesFromAirline.put(route.getAirline(), newRoutesForAirline);
        }

        return route;
    }

    @Override
    public Product save(Product product) throws SQLException {
        products.add(product);

        if (suppliers.containsKey(product.getSupplier())) {
            suppliers.get(product.getSupplier()).add(product);
        } else {
            List<Product> productList = new ArrayList<>();
            productList.add(product);
            suppliers.put(product.getSupplier(), productList);
        }

        return product;
    }

    @Override
    public List<Route> getRoutes(String airline) throws AirlineNotFoundException {
        if (routesFromAirline.containsKey(airline)) {
            return routesFromAirline.get(airline);
        }
        throw new AirlineNotFoundException(airline);
    }

}
