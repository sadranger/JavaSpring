package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value="prototype")
public class Keyboard {
	
	private String enterKey;
	private String spaceBar;
	private String ctrlKey;
	@Autowired
	@Qualifier("lap")
	private Laptop lappy;
	
	
	public Laptop getLappy() {
		return lappy;
	}
	public void setLappy(Laptop lappy) {
		this.lappy = lappy;
	}
	public String getEnterKey() {
		return enterKey;
	}
	public void setEnterKey(String enterKey) {
		this.enterKey = enterKey;
	}
	public String getSpaceBar() {
		return spaceBar;
	}
	public void setSpaceBar(String spaceBar) {
		this.spaceBar = spaceBar;
	}
	public String getCtrlKey() {
		return ctrlKey;
	}
	public void setCtrlKey(String ctrlKey) {
		this.ctrlKey = ctrlKey;
	}
	
	public void onClick() {
		
		System.out.println("Button Clicked");
		lappy.start();
	}

}
