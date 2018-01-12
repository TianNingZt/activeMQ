/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.zzt.message.service.queue;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;

import com.baidu.zzt.message.util.MsgUtil;

public class QueueMsgConsumer {
    private static final String USER = ActiveMQConnection.DEFAULT_USER;
    private static final String PWD = ActiveMQConnection.DEFAULT_PASSWORD;
    private static final String BROKER = ActiveMQConnection.DEFAULT_BROKER_URL;

    public static void main(String[] args) throws JMSException {

        Session session = MsgUtil.getDefaultSession();
        Queue queue = session.createQueue("queue");
        MessageConsumer consumer = session.createConsumer(queue);
        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                try {
                    String text = ((TextMessage) message).getText();
                    System.out.println(text);
                    if (text.equals("发送：0123")) {
//                        System.exit(0);
                    }
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
