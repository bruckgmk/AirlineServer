package com.airline.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.airline.dao.AirportDao;
import com.airline.domain.Airport;
import com.airline.service.AirportService;
import com.airline.dao.GenericDao;


@Service
@Transactional 
public class AirportServiceImpl implements AirportService {
	
 	@Autowired
	private AirportDao airportDao;
	@Override
	public void save(Airport airport) {
		// TODO Auto-generated method stub
		System.out.println("This Is happening");
		airportDao.save(airport);
		
	}




	@Override
	public List<Airport> findAll() {
		// TODO Auto-generated method stub
		return (List<Airport>)airportDao.findAll();
		
	}



	@Override
	public Airport findOne(String code) {
		// TODO Auto-generated method stub
		return airportDao.findOne(code);
	}



	@Override
	public Airport update(Airport airport) {
		// TODO Auto-generated method stub
		return airportDao.update(airport);
	}

}
