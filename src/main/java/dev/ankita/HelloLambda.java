package dev.ankita;

import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;

public class HelloLambda {

    private AmazonSNSClient amazonSNSClient = null;
    private static String EMAIL_TOPIC_ARN = "arn:aws:sns:ap-southeast-2:548453444712:TestTopic";
    private static String EMAIL_SUBJECT = "Unsubscribe Email!!";
    private static String EMAIL_BODY = "Please click Here to unsubscribe from emails. http://localhost:3000/";

    public String handleRequest() {

        amazonSNSClient = (AmazonSNSClient) AmazonSNSClientBuilder.standard().build();
        amazonSNSClient.publish(EMAIL_TOPIC_ARN, EMAIL_BODY, EMAIL_SUBJECT);

        return "Hello Ankita!!";

    }
}
