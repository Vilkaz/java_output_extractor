package com.serverless;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.serverless.handler.OutputExtractor;
import org.apache.log4j.Logger;

import java.util.Map;

public class LambdaHandler implements RequestHandler<Map<String, Object>, String> {

    private static final Logger LOG = Logger.getLogger(LambdaHandler.class);

    @Override
    public String handleRequest(Map<String, Object> input, Context context) {
        String bucket =  String.valueOf(input.get("bucket"));
        String key =  String.valueOf(input.get("key"));
        return new OutputExtractor().extract(bucket, key);
    }
}
