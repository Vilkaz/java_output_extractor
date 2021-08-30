package com.serverless.handler;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.S3Object;
import com.google.gson.Gson;
import com.serverless.aws_clients.S3Client;
import com.serverless.model.TerraformStack;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class OutputExtractor {

    private static final Logger LOG = Logger.getLogger(OutputExtractor.class);
    private static Gson gson = new Gson();

    public String extract(String bucket, String key) {
        LOG.info("extracting outputs from" + bucket + "/" + key);
        AmazonS3 s3Client = new S3Client().get();
        S3Object s3Object = s3Client.getObject(bucket, key);
        TerraformStack terraformStack = s3ToJson(s3Object.getObjectContent());
        return gson.toJson(terraformStack.getOutputs());
    }

    private TerraformStack s3ToJson(InputStream input) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        return gson.fromJson(reader, TerraformStack.class);
    }
}
