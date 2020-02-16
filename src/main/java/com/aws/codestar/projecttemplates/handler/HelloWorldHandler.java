package com.aws.codestar.projecttemplates.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import com.aws.codestar.projecttemplates.GatewayResponse;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

/**
 * Handler for requests to Lambda function.
 */
public class HelloWorldHandler implements RequestHandler<Object, Object> {

    public Object handleRequest(final Object input, final Context context) {
        System.out.println("input:" + input);
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        List<String> languages = Arrays.asList("Java", "Ruby", "python");
        return new GatewayResponse(new JSONObject().put("Output", "Hello World! Hello everyone!!").toString(), headers, 200, languages);
    }
}
