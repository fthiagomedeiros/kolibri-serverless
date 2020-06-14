package com.serverless.routes.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.serverless.routes.business_logic.RouteService;
import com.serverless.routes.business_logic.RouteServiceImpl;
import com.serverless.routes.exceptions.AirlineNotFoundException;
import com.serverless.routes.model.Route;
import utils.ApiGatewayResponse;
import lombok.SneakyThrows;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Map;

import static utils.ExtractBody.extractAuthorizationUser;

public class GetRoutes implements RequestHandler<Map<String, Object>, ApiGatewayResponse> {

    private static final Logger LOG = LogManager.getLogger(GetRoutes.class);

    private final RouteService routeService = new RouteServiceImpl();

    @SneakyThrows
    @Override
    public ApiGatewayResponse handleRequest(Map<String, Object> _event, Context context) {
        String airline = extractAuthorizationUser(_event);

        try {
            List<Route> response = routeService.getRoutes(airline);
            return ApiGatewayResponse.builder()
                    .setStatusCode(200)
                    .setObjectBody(response)
                    .build();
        } catch (AirlineNotFoundException ex) {
            return ApiGatewayResponse.builder()
                    .setStatusCode(404)
                    .build();
        }

    }

}
