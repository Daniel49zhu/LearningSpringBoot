package com.zjc.activemq;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class MsgSender implements CommandLineRunner {

    /**
     * 注入Spring Boot配置好的JmsTemplate的Bean
     */
    @Autowired
    private JmsTemplate jmsTemplate;

    public void run(String... strings) throws Exception {
        // 通过JmsTemplate的send方法向 my-destination 目的地发送Msg消息，这里也等于在消息代理上定义了一个目的地叫my-destination
        jmsTemplate.send("my-destination", new Msg());
    }
}
