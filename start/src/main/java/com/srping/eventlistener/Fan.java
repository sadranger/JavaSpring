package com.srping.eventlistener;

import org.springframework.stereotype.Component;

@Component
public class Fan {
	

	private String state;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public void state() {
		System.out.println(this.state);
	}

}
