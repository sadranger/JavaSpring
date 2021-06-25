package com.spring.dbconnect;

public class Mouse {
	
	private int id;
	private String name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Mouse(int id, String name) {
		this.setId(id);;
		this.setName(name);
	}
	

}
