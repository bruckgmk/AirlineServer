package com.airline.service;

import java.util.List;

import org.springframework.amqp.rabbit.core.RabbitTemplate;

import com.airline.domain.Flight;



public interface FlightService {
	public void save(Flight flight);
	public Flight update(Flight flight);
	public List<Flight> findAll();
	 
	public Flight findOne(String code);
	public void publish(RabbitTemplate rabbitTemplate, List<Flight> flights);

}
