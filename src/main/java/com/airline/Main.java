package com.airline;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



@Component
public class Main {

	@Autowired
	TestData testData;

  public static void main(String[] args) {

    ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
        "context/applicationContext.xml");
    applicationContext.getBean(Main.class).mainInternal(applicationContext);
  }
    private void mainInternal(ApplicationContext applicationContext) {

  
    testData.setData();



 }

}
