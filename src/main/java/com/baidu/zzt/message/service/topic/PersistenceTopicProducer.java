/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.zzt.message.service.topic;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;

public class PersistenceTopicProducer {
    public static void main(String[] args) throws JMSException {
        Connection connection = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_BROKER_URL)
                .createConnection();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        Topic topic = session.createTopic("persisTopic");
        MessageProducer producer = session.createProducer(topic);
        producer.setDeliveryMode(DeliveryMode.PERSISTENT);
        connection.start();
        TextMessage textMessage = session.createTextMessage();
        for (int i = 0; i < 5; i++) {
            textMessage.setText(i + "");
            producer.send(textMessage);
        }
        System.out.println("持久化消息发送完成");
    }
}
