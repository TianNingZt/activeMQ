/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.zzt.message.service.topic;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicSubscriber;

import org.apache.activemq.ActiveMQConnectionFactory;

public class PersistenceTopicConsumer {

    public static void main(String[] args) throws JMSException {
        Connection connection = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_BROKER_URL)
                .createConnection();
        // 对于持久化消息的接收方，必须设置clientId 属性，而且需要先启动一次，用于在JMS Provider中注册其信息，下次启动时才可以获取离线时的消息。
        connection.setClientID("client_id_1");
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Topic topic = session.createTopic("persisTopic");
        TopicSubscriber durableSubscriber = session.createDurableSubscriber(topic, "sub1");
        connection.start();
        for (int i = 0; i < 5; i++) {
            Message receive = durableSubscriber.receive();
            String text = ((TextMessage) receive).getText();
            System.out.println(text);
        }
        System.out.println("接收完毕");
    }
}
