package com.aws.codestar.projecttemplates.handler;

import com.amazonaws.serverless.proxy.internal.testutils.MockLambdaContext;

import com.aws.codestar.projecttemplates.GatewayResponse;

import org.json.JSONObject;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests for {@link HelloWorldHandler}. Modify the tests in order to support your use case as you build your project.
 */
@DisplayName("Tests for HelloWorldHandler")
public class HelloWorldHandlerTest {

    private static final String EXPECTED_CONTENT_TYPE = "application/json";
    private static final String EXPECTED_RESPONSE_VALUE = "Hello World! Hello everyone!!";
    private static final int EXPECTED_STATUS_CODE_SUCCESS = 200;
    private static final String EXPECTED_LANGUAGE1 = "Java";
    private static final String EXPECTED_LANGUAGE2 = "Ruby";
    private static final String EXPECTED_LANGUAGE3 = "python";

    // A mock class for com.amazonaws.services.lambda.runtime.Context
    private final MockLambdaContext mockLambdaContext = new MockLambdaContext();
    private final Object input = new Object();

    /**
     * Initializing variables before we run the tests.
     * Use @BeforeAll for initializing static variables at the start of the test class execution.
     * Use @BeforeEach for initializing variables before each test is run.
     */
    @BeforeAll
    static void setup() {
        // Use as needed.
    }

    /**
     * De-initializing variables after we run the tests.
     * Use @AfterAll for de-initializing static variables at the end of the test class execution.
     * Use @AfterEach for de-initializing variables at the end of each test.
     */
    @AfterAll
    static void tearDown() {
        // Use as needed.
    }

    /**
     * Basic test to verify the result obtained when calling {@link HelloWorldHandler} successfully.
     */
    @Test
    @DisplayName("Basic test for request handler")
    void testHandleRequest() {
        // GatewayResponse response = (GatewayResponse) new HelloWorldHandler().handleRequest(input, mockLambdaContext);

        // // Verify the response obtained matches the values we expect.
        // JSONObject jsonObjectFromResponse = new JSONObject(response.getBody());
        // assertEquals(EXPECTED_RESPONSE_VALUE, jsonObjectFromResponse.get("Output"));
        // assertEquals(EXPECTED_CONTENT_TYPE, response.getHeaders().get("Content-Type"));
        // assertEquals(EXPECTED_STATUS_CODE_SUCCESS, response.getStatusCode());
        // assertEquals(3, response.getLanguages().size());
        // assertEquals(EXPECTED_LANGUAGE1, response.getLanguages().get(0));
        // assertEquals(EXPECTED_LANGUAGE2, response.getLanguages().get(1));
        // assertEquals(EXPECTED_LANGUAGE3, response.getLanguages().get(2));

        // String response = (String) new HelloWorldHandler().handleRequest(input, mockLambdaContext);
        // assertTrue(response.startsWith("<!DOCTYPE html>"));
    }
}
