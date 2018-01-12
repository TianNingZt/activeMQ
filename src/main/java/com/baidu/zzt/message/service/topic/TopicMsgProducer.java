/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.zzt.message.service.topic;

import java.util.concurrent.TimeUnit;

import javax.jms.DeliveryMode;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

import com.baidu.zzt.message.util.MsgUtil;

public class TopicMsgProducer {
    public static void main(String[] args) throws JMSException, InterruptedException {
        Session session = MsgUtil.getDefaultSession();
        Topic topic = session.createTopic("topic");
        MessageProducer producer = session.createProducer(topic);
        producer.setDeliveryMode(DeliveryMode.PERSISTENT);
        TextMessage message= session.createTextMessage("__");
        for (int i = 0; i < 10; i++) {
            message.setText(message.getText()+i);
            producer.send(message);
            TimeUnit.SECONDS.sleep(1);
        }
        System.out.println("topic消息发送成功");
    }

}
