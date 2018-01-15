/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.zzt.message.service.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;

public class QueueServer {

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("business-context.xml");
        JmsTemplate bean = (JmsTemplate) ac.getBean("queueJmsTemplate");
        String msg = (String) bean.receiveAndConvert();
        System.out.println("接收到的消息是: " + msg);
    }
}
