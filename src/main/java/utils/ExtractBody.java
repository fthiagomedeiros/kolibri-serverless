package utils;

import java.util.LinkedHashMap;
import java.util.Map;

public class ExtractBody {

    /**
     * Extract body from request
     * @param _event the event received into the lambda
     * @return the body
     */
    public static String extractBody(Map<String, Object> _event) {
        return _event.get("body").toString();
    }

    /**
     * This method will be used to extract from token the logged user id
     * @param _event the event
     * @return the logged user id
     */
    public static String extractAuthorizationUser(Map<String, Object> _event) {
        return ((LinkedHashMap) _event.get("headers")).get("Authorization").toString();
    }

    public static String getToken(Map<String, Object> _event) {
        return _event.get("authorizationToken").toString();
    }
}