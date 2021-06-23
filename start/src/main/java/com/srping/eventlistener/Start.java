package com.srping.eventlistener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Start {

	public static void main(String[] args) {
		
		ApplicationContext con = new ClassPathXmlApplicationContext("event.xml");
		Light l = (Light) con.getBean("light");
		l.state();
		
	}

}
