/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.zzt.message.service.queue;

import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import com.baidu.zzt.message.util.MsgUtil;

public class QueueMsgProducer {

    public static void main(String[] args) throws JMSException {
        Session session = MsgUtil.getDefaultSession();
        Queue queue = session.createQueue("queue");
        MessageProducer producer = session.createProducer(queue);
        for (int i = 0; i < 10; i++) {
            TextMessage message = session.createTextMessage(i + "");
            producer.send(message);
        }
        System.out.println("消息发送成功..");
        producer.close();
    }

}
