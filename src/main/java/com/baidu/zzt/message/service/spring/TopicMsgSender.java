/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.zzt.message.service.spring;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class TopicMsgSender {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("business-context.xml");
        JmsTemplate template = (JmsTemplate) ac.getBean("topicJmsTemplate");

        template.send(new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                TextMessage textMessage = session.createTextMessage("spring-topic");
                System.out.println("消息发送成功！");
                return textMessage;
            }
        });
    }
}
