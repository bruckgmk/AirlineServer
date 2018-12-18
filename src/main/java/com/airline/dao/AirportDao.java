package com.airline.dao;

import org.springframework.stereotype.Repository;

import com.airline.domain.Airport;

@SuppressWarnings("unchecked")
@Repository
public interface AirportDao extends GenericDao<Airport> {
      
	public Airport findByCode(String code);
}
