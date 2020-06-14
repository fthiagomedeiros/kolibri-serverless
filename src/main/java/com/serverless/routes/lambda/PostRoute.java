package com.serverless.routes.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.serverless.routes.business_logic.RouteService;
import com.serverless.routes.business_logic.RouteServiceImpl;
import com.serverless.routes.model.Route;
import com.serverless.routes.request.CreateRouteRequest;
import com.serverless.routes.response.ApiGatewayResponse;
import lombok.SneakyThrows;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

import static utils.ExtractBody.extractAuthorizationUser;
import static utils.ExtractBody.extractBody;

public class PostRoute implements RequestHandler<Map<String, Object>, ApiGatewayResponse> {

    private static final Logger LOG = LogManager.getLogger(PostRoute.class);
    private final ObjectMapper mapper = new ObjectMapper();
    private final RouteService routeService = new RouteServiceImpl();

    @SneakyThrows
    @Override
    public ApiGatewayResponse handleRequest(Map<String, Object> _event, Context context) {
        String body = extractBody(_event);
        String loggedUser = extractAuthorizationUser(_event);

        CreateRouteRequest request = mapper.readValue(body, CreateRouteRequest.class);
        request.setAirline(loggedUser);

        LOG.info("Route handleRequest: {}", body);

        Route response = routeService.createRoute(request);

        return ApiGatewayResponse.builder()
                .setStatusCode(201)
                .setObjectBody(response)
                .build();
    }
}
