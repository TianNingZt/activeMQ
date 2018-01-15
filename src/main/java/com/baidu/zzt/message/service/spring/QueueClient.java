/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.zzt.message.service.spring;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class QueueClient {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("business-context.xml");
        JmsTemplate template = (JmsTemplate) ac.getBean("queueJmsTemplate");
        template.send(new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                return session.createTextMessage("spring_textMsg");
            }
        });
    }
}
