package com.airline.dao.Impl;

 

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.airline.domain.Airport;
import com.airline.dao.AirportDao;



@SuppressWarnings("unchecked")
@Repository
public class AirportDaoImpl extends GenericDaoImpl<Airport> implements AirportDao {

	public AirportDaoImpl() {
		System.out.println("Testing");
		super.setDaoType(Airport.class );
		System.out.println("WOR");
		}


	@Override
	public Airport findByCode(String code) {
		// TODO Auto-generated method stub
		Query query = entityManager.createQuery("select c from Airport c  where c.code =:code");
		return (Airport) query.setParameter("code", code).getSingleResult();
	}


 }