package com.airline.dao;


import org.springframework.stereotype.Repository;

import com.airline.domain.Flight;

@SuppressWarnings("unchecked")
@Repository
public interface FlightDao extends GenericDao<Flight> {
      
	public Flight findByNumber(String number);
}
