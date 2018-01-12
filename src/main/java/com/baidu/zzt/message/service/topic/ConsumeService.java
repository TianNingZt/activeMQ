/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.zzt.message.service.topic;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import com.baidu.zzt.message.util.MsgUtil;

public class ConsumeService extends Thread {
    @Override
    public void run() {
        Session session = MsgUtil.getDefaultSession();
        try {
            Topic topic = session.createTopic("topic");
            MessageConsumer consumer = session.createConsumer(topic);
            consumer.setMessageListener(new MessageListener() {
                @Override
                public void onMessage(Message message) {
                    try {
                        String text = ((TextMessage) message).getText();
                        System.out.println(Thread.currentThread().getName() + text);
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
