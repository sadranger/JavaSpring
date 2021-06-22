package com.spring.start;

import org.springframework.stereotype.Component;


public class Bluetooth implements Network  {
	
	private Specs spec;
	
	
	

	public Specs getspecs() {
		return spec;
	}




	public void setSpecs(Specs specs) {
		this.spec = specs;
	}
	
	




	public void state() {
		System.out.println("Bluetooth is OFF");
		System.out.println("Properties of the " +
				  spec.getName() +"are :\n"+ "Range: "+ spec.getRange()+"\n"+ "Indicator: "+
				  spec.getIndicator() +"\n"+ "Speed: " + spec.getSpeed());
	}
}
