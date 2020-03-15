package com.aws.codestar.projecttemplates.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.S3Event;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.event.S3EventNotification.S3EventNotificationRecord;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

import com.aws.codestar.projecttemplates.GatewayResponse;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * Handler for requests to Lambda function.
 */
public class HelloWorldHandler implements RequestHandler<S3Event, Object> {

    private final String TXT_MIME = "text/plain";

    public Object handleRequest(final S3Event input, final Context context) {
        // System.out.println("input:" + input);
        Map<String, String> headers = new HashMap<>();
        // headers.put("Content-Type", "application/json");
        // List<String> languages = Arrays.asList("Java", "Ruby", "python");
        // return new GatewayResponse(new JSONObject().put("Output", "Hello World! Hello everyone!!").toString(), headers, 200, languages);
        // return new GatewayResponse(new JSONObject().put("Output", "Hello World! Hello everyone!!").toString(), headers, 200);

        S3EventNotificationRecord record = input.getRecords().get(0);
        String srcBucket = record.getS3().getBucket().getName();
        // Object key may have spaces or unicode non-ASCII characters.
        String srcKey = record.getS3().getObject().getUrlDecodedKey();
        AmazonS3 s3Client = AmazonS3ClientBuilder.defaultClient();
        S3Object s3Object = s3Client.getObject(new GetObjectRequest(srcBucket, srcKey));
        InputStream objectData = s3Object.getObjectContent();
        // Re-encode image to target format
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            int i = 0;
            while((i = objectData.read())!=-1) {
                os.write(i);
            }
            os.write(13);
            os.write(65);
            os.write(66);
            os.write(13);
        } catch (Exception e) {
            System.err.println(e);
            System.exit(1);
        }
        InputStream is = new ByteArrayInputStream(os.toByteArray());
        // Set Content-Length and Content-Type
        ObjectMetadata meta = new ObjectMetadata();
        meta.setContentLength(os.size());
        meta.setContentType(TXT_MIME);

        // Uploading to S3 destination bucket
        System.out.println("Writing to: " + srcBucket + "/" + srcKey + "_");
        try {
            s3Client.putObject(srcBucket, srcKey + "_", is, meta);
        }
        catch(AmazonServiceException e)
        {
            System.err.println(e.getErrorMessage());
            System.exit(1);
        }
        System.out.println("Successfully arranged " + srcBucket + "/"
                + srcKey);

        headers.put("Content-Type", "text/html");
        return new GatewayResponse("<!DOCTYPE html><html lang=\"ja\"><head><meta charset=\"UTF-8\"><title>my page</title><body><h3>Hello, World!!</h3></body></html>", headers, 200);
    }
}
