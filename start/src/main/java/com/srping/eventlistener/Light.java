package com.srping.eventlistener;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

@Component
public class Light implements ApplicationEventPublisherAware {
	
	private String state;
	private ApplicationEventPublisher publisher;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public void state() {
		System.out.println(this.state);
		DrawEvent drawEvent = new DrawEvent(this);
		publisher.publishEvent(drawEvent);
		
	}

	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.publisher = applicationEventPublisher;
		
	}
	

}
