package com.serverless.person.lambda;


public class GetPerson implements RequestHandler<Map<String, Object>, ApiGatewayResponse> {

    @Override
    public ApiGatewayResponse handleRequest(Map<String, Object> _event, Context context) {
        return ApiGatewayResponse.builder()
                .setStatusCode(200)
                .setObjectBody("It works!!!")
                .build();
    }
}
