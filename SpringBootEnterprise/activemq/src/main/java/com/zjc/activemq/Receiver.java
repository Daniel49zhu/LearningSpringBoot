package com.zjc.activemq;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    /**
     * @param message
     * @JmsListener是Spring4.1提供的一个新特性，用来简化JMS开发，只需添加一个注解，使用destination属性指定要监听的目的地， 即可接收该目的地发送的消息
     */
    @JmsListener(destination = "my-destination")
    public void receiverMessage(String message) {
        System.out.println("接收到：[" + message + "]");
    }
}
