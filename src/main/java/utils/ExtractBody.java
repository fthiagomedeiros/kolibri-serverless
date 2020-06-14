package utils;

import java.util.LinkedHashMap;
import java.util.Map;

public class ExtractBody {

    public static String extractBody(Map<String, Object> _event) {
        return _event.get("body").toString();
    }

    public static String extractAuthorizationUser(Map<String, Object> _event) {
        return ((LinkedHashMap) _event.get("headers")).get("Authorization").toString();
    }

}