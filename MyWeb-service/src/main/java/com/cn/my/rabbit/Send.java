package com.cn.my.rabbit;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * Created by gcb on 2018/1/25.
 * 使用场景：简单的发送与接收，没有特别的处理。
 * 1、使用“task_queue”声明了另一个Queue，因为RabbitMQ不容许声明2个相同名称、配置不同的Queue

 2、使"task_queue"的Queue的durable的属性为true，即使消息队列durable

 3、使用MessageProperties.PERSISTENT_TEXT_PLAIN使消息durable

 When RabbitMQ quits or crashes it will forget the queues and messages unless you tell it not to.
 Two things are required to make sure that messages aren't lost:
 we need to mark both the queue and messages as durable.
 */
public class Send {
    private final static String QUEUE_NAME = "hello";

    public static void main(String[] argv) throws Exception {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        String message = "Hello World!";
        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
        System.out.println(" [x] Sent '" + message + "'");

        channel.close();
        connection.close();
    }
}
