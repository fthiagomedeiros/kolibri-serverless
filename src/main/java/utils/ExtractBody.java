package utils;

import java.util.Map;

public class ExtractBody {

    public static String extractBody(Map<String, Object> _event) {
        return _event.get("body").toString();
    }

}