/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.zzt.message.service.queue;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import com.baidu.zzt.message.util.MsgUtil;

public class QueueMsgConsumer {

    public static void main(String[] args) throws JMSException {

        Session session = MsgUtil.getDefaultSession();
        Queue queue = session.createQueue("queue");
        MessageConsumer consumer = session.createConsumer(queue);
        for (int i = 0; i < 20; i++) {
            Message receive = consumer.receive();
            System.out.println(((TextMessage) receive).getText());
        }
//        session.commit();
        System.out.println("接受成功！");
    }

}
