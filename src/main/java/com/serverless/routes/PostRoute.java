package com.serverless.routes;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.serverless.routes.response.ApiGatewayResponse;
import com.serverless.routes.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

public class PostRoute implements RequestHandler<Map<String, Object>, ApiGatewayResponse> {

    private static final Logger LOG = LogManager.getLogger(PostRoute.class);

    @Override
    public ApiGatewayResponse handleRequest(Map<String, Object> stringObjectMap, Context context) {
        LOG.info("received: {}", stringObjectMap);

        Response responseBody = new Response("POST", "Works");
        return ApiGatewayResponse.builder()
                .setStatusCode(201)
                .setObjectBody(responseBody)
                .build();
    }
}
