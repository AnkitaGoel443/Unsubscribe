package dev.ankita;

import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import com.amazonaws.services.sns.model.ListSubscriptionsResult;
import com.amazonaws.services.sns.model.Subscription;
import java.util.List;

public class ReactLambda {

    private AmazonSNSClient amazonSNSClient = null;
    private static String TOPIC_ARN = "arn:aws:sns:ap-southeast-2:548453444712:TestTopic";

    public String handleRequest() {

        amazonSNSClient = (AmazonSNSClient) AmazonSNSClientBuilder.standard().build();
        ListSubscriptionsResult subscriptions = amazonSNSClient.listSubscriptions();
        String subscriptionTopicArn = subscriptions.getSubscriptions().get(0).getSubscriptionArn();
        amazonSNSClient.unsubscribe(subscriptionTopicArn);

        return "Hello SNS!!";

    }
}
