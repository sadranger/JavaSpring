package com.spring.start;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import javax.annotation.*;


@Controller
public class Bluetooth implements Network  {
	
	private Specs specs;
	
	private MessageSource messageSource;
	
	
	

	public MessageSource getMessageSource() {
		return messageSource;
	}


	@Autowired
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}



	public Specs getspecs() {
		return specs;
	}



	//@SuppressWarnings("deprecation")
	@Autowired
	@Qualifier("qualify")
	public void setSpecs(Specs specs) {
		this.specs = specs;
	}
	



	public void state() {
		
		System.out.println("Bluetooth is OFF"+"\n"+ messageSource.getMessage("greet", null, null));
		System.out.println(messageSource.getMessage("prop", new Object[] {specs.getName(), specs.getRange(), specs.getIndicator(), specs.getSpeed()}, null));
		/*
		 * System.out.println("Properties of the " + specs.getName() +"are :\n"+
		 * "Range: "+ specs.getRange()+"\n"+ "Indicator: "+ specs.getIndicator() +"\n"+
		 * "Speed: " + specs.getSpeed());
		 */
	}
}
