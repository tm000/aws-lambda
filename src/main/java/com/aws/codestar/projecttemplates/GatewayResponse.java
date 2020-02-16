package com.aws.codestar.projecttemplates;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * POJO containing response object for API Gateway.
 */
public class GatewayResponse {

    private final String body;
    private final Map<String, String> headers;
    private final int statusCode;
    private final List<String> languages;

    public GatewayResponse(final String body, final Map<String, String> headers, final int statusCode, List<String> languages) {
        this.statusCode = statusCode;
        this.body = body;
        this.headers = Collections.unmodifiableMap(new HashMap<>(headers));
        this.languages = Collections.unmodifiableList(new ArrayList<>(languages));
    }

    public String getBody() {
        return body;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public List<String> getLanguages() {
        return languages;
    }
}
