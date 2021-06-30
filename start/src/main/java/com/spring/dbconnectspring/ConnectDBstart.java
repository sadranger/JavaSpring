package com.spring.dbconnectspring;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConnectDBstart {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("db.xml");
		NamedJdbcTemplate named = context.getBean("namedJdbcTemplate",NamedJdbcTemplate.class);
		//System.out.println(named.getRows(2, "Left Click"));
		for(Mouse ms: named.getRows(3,"inserted2301"))
			 System.out.println(ms.getId()+" | "+ms.getName()+" | "+ms.getName2());
		
		/*
		 * ConnectDAOInit co = context.getBean("connectDAOInit",ConnectDAOInit.class);
		 * 
		 * 
		 * ConnectDAOInit co2 = context.getBean("connectDAOInit",ConnectDAOInit.class);
		 * ConnectDAOInit co3 = context.getBean("connectDAOInit",ConnectDAOInit.class);
		 * ConnectDAOInit co4 = context.getBean("connectDAOInit",ConnectDAOInit.class);
		 * Mouse m = co.getMouse(2, "Left Click"); Mouse m2 = co2.getMouse(2,
		 * "Left Click"); Mouse m3 = co3.getMouse(2, "Left Click"); Mouse m4 =
		 * co4.getMouse(2, "Left Click"); System.out.println(m.getName());
		 * System.out.println(m2.getName()); System.out.println(m3.getName());
		 * System.out.println(m4.getName());
		 * 
		 * 
		 * System.out.println("\nCount of all records:" + co.getCountRows(3));
		 * co.insertTable(3, "inserted2301");
		 * 
		 * for(Mouse ms: co.getWholeRecords(1))
		 * System.out.println(ms.getId()+" | "+ms.getName()+" | "+ms.getName2());
		 */
		
		
		
	}

}
