package com.airline.dao.Impl;

 

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.airline.domain.Flight;
import com.airline.dao.FlightDao;



@SuppressWarnings("unchecked")
@Repository
public class FlightDaoImpl extends GenericDaoImpl<Flight> implements FlightDao {

	public FlightDaoImpl() {
		super.setDaoType(Flight.class );
		}





	@Override
	public Flight findByNumber(String number) {
		// TODO Auto-generated method stub
		Query query = entityManager.createQuery("select n from Flight f  where f.number =:number");
		return (Flight) query.setParameter("number", number).getSingleResult();
	}


 }