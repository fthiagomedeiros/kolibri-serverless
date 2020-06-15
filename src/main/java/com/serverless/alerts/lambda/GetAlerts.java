package com.serverless.alerts.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.serverless.alerts.business_logic.Alertservice;
import com.serverless.alerts.business_logic.AlertserviceImpl;
import com.serverless.alerts.exceptions.AirlineNotFoundException;
import com.serverless.alerts.model.Route;
import com.serverless.alerts.response.CreateRouteResponseError;
import utils.ApiGatewayResponse;
import lombok.SneakyThrows;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Map;

import static utils.ExtractBody.extractAuthorizationUser;

public class GetAlerts implements RequestHandler<Map<String, Object>, ApiGatewayResponse> {

    private static final Logger LOG = LogManager.getLogger(GetAlerts.class);

    private final Alertservice Alertservice = new AlertserviceImpl();

    @SneakyThrows
    @Override
    public ApiGatewayResponse handleRequest(Map<String, Object> _event, Context context) {
        String buyer;
        try {
            buyer = extractAuthorizationUser(_event);
        } catch (Exception ex) {
            return ApiGatewayResponse.builder()
                    .setStatusCode(400)
                    .setObjectBody(new CreateRouteResponseError(400, "Unauthorized"))
                    .build();
        }

        try {
            List<Route> response = Alertservice.getAlerts(buyer);
            return ApiGatewayResponse.builder()
                    .setStatusCode(200)
                    .setObjectBody(response)
                    .build();
        } catch (BuyerNotFoundException ex) {
            return ApiGatewayResponse.builder()
                    .setStatusCode(404)
                    .setObjectBody(new CreateRouteResponseError(404, ex.getMessage()))
                    .build();
        }

    }

}
