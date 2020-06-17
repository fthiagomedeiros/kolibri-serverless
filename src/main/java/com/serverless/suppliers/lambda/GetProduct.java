package com.serverless.suppliers.lambda;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.serverless.suppliers.business_logic.ProductService;
import com.serverless.suppliers.business_logic.ProductServiceImpl;
import com.serverless.suppliers.model.Product;
import lombok.SneakyThrows;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utils.ApiGatewayResponse;

import java.util.List;
import java.util.Map;

import static utils.ExtractBody.extractAuthorizationUser;

public class GetProduct implements RequestHandler<Map<String, Object>, ApiGatewayResponse> {

    private static final Logger LOG = LogManager.getLogger(GetProduct.class);
    private final ObjectMapper mapper = new ObjectMapper();
    private final ProductService productService = new ProductServiceImpl();

    @SneakyThrows
    @Override
    public ApiGatewayResponse handleRequest(Map<String, Object> _event, Context context) {
        String loggedUser = extractAuthorizationUser(_event);

        List<Product> response = productService.getProducts(loggedUser);
        return ApiGatewayResponse.builder()
                .setStatusCode(201)
                .setObjectBody(response)
                .build();
    }
}
