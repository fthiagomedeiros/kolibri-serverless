package com.serverless;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ApiGatewayResponse {

	private final int statusCode;
	private final String body;

	public ApiGatewayResponse(int statusCode, String body) {
		this.statusCode = statusCode;
		this.body = body;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public String getBody() {
		return body;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {

		private static final Logger LOG = LogManager.getLogger(ApiGatewayResponse.Builder.class);

		private static final ObjectMapper objectMapper = new ObjectMapper();

		private int statusCode = 200;
		private String rawBody;
		private Object objectBody;

		public Builder setStatusCode(int statusCode) {
			this.statusCode = statusCode;
			return this;
		}

		/**
		 * Builds the {@link ApiGatewayResponse} using the passed raw body string.
		 */
		public Builder setRawBody(String rawBody) {
			this.rawBody = rawBody;
			return this;
		}

		/**
		 * Builds the {@link ApiGatewayResponse} using the passed object body
		 * converted to JSON.
		 */
		public Builder setObjectBody(Object objectBody) {
			this.objectBody = objectBody;
			return this;
		}

		public ApiGatewayResponse build() {
			String body = null;
			if (rawBody != null) {
				body = rawBody;
			} else if (objectBody != null) {
				try {
					body = objectMapper.writeValueAsString(objectBody);
				} catch (JsonProcessingException e) {
					LOG.error("failed to serialize object", e);
					throw new RuntimeException(e);
				}
			}
			return new ApiGatewayResponse(statusCode, body);
		}
	}
}
