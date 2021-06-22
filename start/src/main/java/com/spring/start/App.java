package com.spring.start;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    private static ApplicationContext con;

	public static void main( String[] args )
    {
    	
        con = new ClassPathXmlApplicationContext("config.xml");
        ((AbstractApplicationContext) con).registerShutdownHook();
        
        Network n = (Network) con.getBean("bluetooth");
        n.state();
        //System.out.println(n.toString());
        
		/*
		 * Band b = (Band) con.getBean("band"); System.out.println(b.toString());
		 */
    }
}
