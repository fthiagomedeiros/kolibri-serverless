package com.serverless.routes.response;

import com.serverless.routes.request.CreateRouteRequest;
import lombok.Data;

public @Data
class Response {

	private final CreateRouteRequest request;

	public Response(CreateRouteRequest request) {
		this.request = request;
	}

}
