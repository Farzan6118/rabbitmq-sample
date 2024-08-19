package com.example.sub.receive;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("routing")
public class RoutingReceiver {

    @RabbitListener(queues = "#{autoDeleteQueue1.name}")
    public void receive1(String message) {
        System.out.println(message + " from Queue1");
    }

    @RabbitListener(queues = "#{autoDeleteQueue2.name}")
    public void receive2(String message) {
        System.out.println(message + " from Queue2");
    }

}