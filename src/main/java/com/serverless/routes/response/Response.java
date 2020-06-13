package com.serverless.routes.response;

import lombok.Data;

public @Data
class Response {

	private final String name;
	private final String message;

	public Response(String name, String message) {
		this.name = name;
		this.message = message;
	}

}
