/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.zzt.message.util;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class MsgUtil {
    private static final String USER = ActiveMQConnection.DEFAULT_USER;
    private static final String PWD = ActiveMQConnection.DEFAULT_PASSWORD;
    //    private static final String BROKER = ActiveMQConnection.DEFAULT_BROKER_URL;
    private static final String BROKER = "tcp://localhost:666";

    public static Session getDefaultSession() {
        Session session = null;
        try {
            ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(USER, PWD, BROKER);
            Connection connection = connectionFactory.createConnection();
            connection.start();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return session;
    }
}
