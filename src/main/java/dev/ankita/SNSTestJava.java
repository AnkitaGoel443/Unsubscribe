package dev.ankita;

import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.AmazonSNSClientBuilder;
import com.amazonaws.services.sns.model.ListSubscriptionsResult;

public class SNSTestJava {

    private static AmazonSNSClient amazonSNSClient = null;
    private static String EMAIL_TOPIC_ARN = "arn:aws:sns:ap-southeast-2:548453444712:TestTopic";

    public static void main(String[] args){
        amazonSNSClient = (AmazonSNSClient) AmazonSNSClientBuilder.standard().build();
        //amazonSNSClient.publish(EMAIL_TOPIC_ARN, "SNS verified", "Amazon SNS says hi!!");

        ListSubscriptionsResult subscriptions = amazonSNSClient.listSubscriptions();
        String subscriptionTopicArn = subscriptions.getSubscriptions().get(0).getTopicArn();
        amazonSNSClient.unsubscribe(subscriptionTopicArn);

    }

}
