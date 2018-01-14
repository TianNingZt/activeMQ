/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.zzt.message.service.broker;

import org.apache.activemq.broker.BrokerFactory;
import org.apache.activemq.broker.BrokerService;

/**
 * 使用内嵌的方式启动broker
 */
public class LocalBroker {
    public static void main(String[] args) throws Exception {
        //start1();
        start2();
    }

    private static void start2() throws Exception {
        // 注意文件名前面要加 properties:  否则加载不了
        String url = "properties:broker.properties";
        BrokerService broker = BrokerFactory.createBroker(url);
        broker.addConnector("tcp://localhost:666");
        broker.start();

    }

    public static void start1() throws Exception {
        BrokerService service = new BrokerService();
        service.setUseJmx(true);
        service.addConnector("tcp://localhost:666");
        service.start();
    }
}
