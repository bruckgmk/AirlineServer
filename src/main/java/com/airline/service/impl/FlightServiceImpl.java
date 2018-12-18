package com.airline.service.impl;

import java.util.List;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.airline.dao.FlightDao;
import com.airline.domain.Flight;
import com.airline.service.FlightService;

@Service
@Transactional 
public class FlightServiceImpl implements FlightService{
 	@Autowired
	private FlightDao flightDao;
 	@Override
	public void save(Flight flight) {
		// TODO Auto-generated method stub
		flightDao.save(flight);
		
	}



 	@Override
	public List<Flight> findAll() {
		// TODO Auto-generated method stub
		return (List<Flight>)flightDao.findAll();
		
	}


 	@Override
	public Flight findOne(String number) {
		// TODO Auto-generated method stub
		return flightDao.findOne(number);
	}


 	@Override
	public Flight update(Flight flight) {
		// TODO Auto-generated method stub
		return flightDao.update(flight);
	}



	@Override
	public void publish(RabbitTemplate rabbitTemplate, List<Flight> flights) {
		// TODO Auto-generated method stub
		for(Flight flight:flights) {
			rabbitTemplate.convertAndSend(flight);
		}
		
	}












}
