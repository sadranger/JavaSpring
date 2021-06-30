package com.spring.hibernatedb;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StartCon {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("hibernate.xml");
		HibernateDaoCon con = context.getBean("HibernateDaoCon",HibernateDaoCon.class);
		System.out.println(con.getCountOfRows());
	}

}
