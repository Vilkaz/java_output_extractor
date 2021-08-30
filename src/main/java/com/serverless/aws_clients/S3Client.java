package com.serverless.aws_clients;

import com.amazonaws.auth.DefaultAWSCredentialsProviderChain;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

public class S3Client {

    private static AmazonS3 s3Client;

    public AmazonS3 get() {
        if (s3Client == null) {
            s3Client = AmazonS3ClientBuilder.standard()
                    .withRegion(System.getenv("REGION"))
                    .withCredentials(new DefaultAWSCredentialsProviderChain())
                    .build();
        }
        return s3Client;
    }

}
