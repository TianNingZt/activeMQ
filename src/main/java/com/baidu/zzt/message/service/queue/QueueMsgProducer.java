/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.zzt.message.service.queue;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import com.baidu.zzt.message.util.MsgUtil;

public class QueueMsgProducer {
    public static void main(String[] args) throws JMSException {
        Session session = MsgUtil.getDefaultSession();
        Queue queue = session.createQueue("queue");
        MessageProducer producer = session.createProducer(queue);
        TextMessage message = session.createTextMessage("发送：");
        for (int i = 0; i < 10; i++) {
            message.setText(message.getText() + i);
            producer.send(message);
        }
        System.out.println("消息发送成功");
        producer.close();
    }

}
