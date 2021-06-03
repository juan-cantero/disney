package io.juanqui.disney.exceptions.models;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

public class ExceptionBody {
    private String message;

    public ExceptionBody(String message) {
        this.message = message;

    }

    public Map<String,Object> getBody() {
        Map<String,Object> body = new LinkedHashMap<>();
        body.put("message",this.message);
        body.put("timeStamp", LocalDateTime.now());
        return body;

    }
}
