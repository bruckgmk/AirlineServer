package com.airline.service;

import java.util.List;

import com.airline.domain.Airport;


public interface AirportService {

	public void save(Airport airport);
	public Airport update(Airport airport);
	public List<Airport> findAll();
	 
	public Airport findOne(String code);
}
