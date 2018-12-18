package com.airline.amqp;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

import com.airline.domain.Item;

public class ItemServiceImpl implements ItemService {

	public void publish(RabbitTemplate rabbitTemplate) {
    	// Dummy up an Item
    	// First need a Product:
    	Item item = new Item("Kazoo", "a Hummer");
        rabbitTemplate.convertAndSend(item);
        item = new Item("Hammer", "Ball Pean");
        rabbitTemplate.convertAndSend(item);
	}
}
