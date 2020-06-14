package com.serverless.suppliers.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.serverless.suppliers.business_logic.ProductService;
import com.serverless.suppliers.business_logic.ProductServiceImpl;
import lombok.SneakyThrows;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.ApiGatewayResponse;

import java.util.Map;

public class PostProduct implements RequestHandler<Map<String, Object>, ApiGatewayResponse> {

    private static final Logger LOG = LogManager.getLogger(PostProduct.class);
    private final ObjectMapper mapper = new ObjectMapper();
    private final ProductService routeService = new ProductServiceImpl();

    @SneakyThrows
    @Override
    public ApiGatewayResponse handleRequest(Map<String, Object> _event, Context context) {

        return ApiGatewayResponse.builder()
                .setStatusCode(201)
                .setObjectBody("new product")
                .build();
    }
}
