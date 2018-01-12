/*
 * Copyright (C) 2018 Baidu, Inc. All Rights Reserved.
 */
package com.baidu.zzt.message.service.topic;

import java.util.concurrent.TimeUnit;

public class TopicMsgConsumer {
    public static void main(String[] args) throws InterruptedException {
        new ConsumeService().start();
        TimeUnit.SECONDS.sleep(2);
        new ConsumeService().start();
        TimeUnit.SECONDS.sleep(2);
        new ConsumeService().start();
    }
}
