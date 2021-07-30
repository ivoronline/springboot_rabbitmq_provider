package com.ivoronline.springboot_rabbitmq_provider;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

  @Autowired RabbitTemplate template;
  @Autowired Queue          queue;

  @Bean
  public Queue getQueue() {
    return new Queue("Queue1");
  }

  @RequestMapping("SendMessage")
  String sendMessage(@RequestParam String message) {
    template.convertAndSend(queue.getName(), message);
    return "Sent Message: " + message;
  }

}
