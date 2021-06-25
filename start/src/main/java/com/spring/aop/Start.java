package com.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.keyselect.KeySelect;


public class Start {
	
	public static void main(String []are) {
		ApplicationContext con = new ClassPathXmlApplicationContext("aop.xml");
		
		KeySelect key = con.getBean("keySelect",KeySelect.class);
		System.out.println(key.getMouse().getKey());
		
	}

}
