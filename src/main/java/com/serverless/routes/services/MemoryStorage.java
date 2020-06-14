package com.serverless.routes.services;

import com.serverless.routes.exceptions.AirlineNotFoundException;
import com.serverless.routes.model.Route;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoryStorage implements DataStorage {

    private static final List<Route> routes = new ArrayList<>();
    private static final Map<String, List<Route>> routesFromAirline = new HashMap<>();

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
    public List<Route> getRoutes() {
        return routes;
    }

    @Override
    public List<Route> getRoutes(String airline) throws AirlineNotFoundException {
        if (routesFromAirline.containsKey(airline)) {
            return routesFromAirline.get(airline);
        }
        throw new AirlineNotFoundException(airline);
    }


}
