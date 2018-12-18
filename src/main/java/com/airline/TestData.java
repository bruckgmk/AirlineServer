package com.airline;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.airline.domain.Airport;
import com.airline.domain.Flight;
import com.airline.service.AirportService;
import com.airline.service.FlightService;


@Component
public class TestData {
	@Autowired
	AirportService airportService;
	
	@Autowired
	FlightService flightService;
	List<Flight> flights = new ArrayList<Flight>();

	public void setData() {
		// TODO Auto-generated method stub
		Airport airport = new Airport();
		airport.setCode("NY024");
		airport.setName("New York International Airport");
		airport.setCity("NewYork");
		
		Airport airport2 = new Airport();
		airport2.setCode("IA016");
		airport2.setName("Cedar Rapids");
		airport2.setCity("Iowa City");
		
		airportService.save(airport);
		airportService.save(airport2);
		Flight flight = new Flight();
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		Date departureDateTime1 = null;
		Date arrivalDateTime1 = null;
		try {
			departureDateTime1 = formatter.parse("2018-12-17 08:34:55.705");
			arrivalDateTime1 = formatter.parse("2018-12-26 06:14:55.705");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
				System.out.println(departureDateTime1);
				System.out.println(arrivalDateTime1);
		flight.setArrivalTime(arrivalDateTime1);
		flight.setDepartureTime(departureDateTime1);
		flight.setFromAirport(airport);
		flight.setNumber("301");
		flight.setFromAirport(airport);
		flight.setToAirport(airport2);
		
		flightService.save(flight);
		flights.add(flight);
        ApplicationContext context = new GenericXmlApplicationContext("classpath:context/flight-info-context.xml");
        System.out.println("OK Rabbit");
        RabbitTemplate directTemplate =  context.getBean("directTemplate",RabbitTemplate.class);
        flightService.publish(directTemplate,flights);

 
        try {
        	System.out.println("Rabbit One..");
			Thread.sleep(1000);
			System.out.println("Check One.. ");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//flight.setArrivalTime("");
	}
}
