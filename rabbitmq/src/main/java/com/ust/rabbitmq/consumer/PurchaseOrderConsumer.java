package com.ust.rabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.ust.rabbitmq.config.MessagingConfig;
import com.ust.rabbitmq.model.OrderStatus;

@Component
public class PurchaseOrderConsumer {
	
	@Value("${ust.rabbitmq.queue}")
	  String ust_queue;
	
	@Value("${ust.rabbitmq.exchange}")
	  String exchange;
	
	@Value("${ust.rabbitmq.routingkey}")
	  String routingkey;

	
	
	@RabbitListener(queues="ust_queue")
	public void consumerMessageFromQueue
	(OrderStatus orderStatus) {
	System.out.println("message recieved from queue" + orderStatus);
	}
}
