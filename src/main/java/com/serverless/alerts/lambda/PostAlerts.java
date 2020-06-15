package com.serverless.alerts.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.serverless.alerts.business_logic.Alertservice;
import com.serverless.alerts.business_logic.AlertserviceImpl;
import com.serverless.alerts.model.Route;
import com.serverless.alerts.request.CreateRouteRequest;
import utils.ApiGatewayResponse;
import lombok.SneakyThrows;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

import static utils.ExtractBody.extractAuthorizationUser;
import static utils.ExtractBody.extractBody;

public class PostRoute implements RequestHandler<Map<String, Object>, ApiGatewayResponse> {

    private static final Logger LOG = LogManager.getLogger(PostRoute.class);
    private final ObjectMapper mapper = new ObjectMapper();
    private final Alertservice Alertservice = new AlertserviceImpl();

    @SneakyThrows
    @Override
    public ApiGatewayResponse handleRequest(Map<String, Object> _event, Context context) {
        String body = extractBody(_event);
        String loggedUser = extractAuthorizationUser(_event);

        CreateRouteRequest request = mapper.readValue(body, CreateRouteRequest.class);
        request.setBuyer(loggedUser);

        LOG.info("Route handleRequest: {}", body);

        Route response = Alertservice.createAlert(request);

        return ApiGatewayResponse.builder()
                .setStatusCode(201)
                .setObjectBody(response)
                .build();
    }
}
