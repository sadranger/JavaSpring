package com.spring.dbconnectspring;

public class Mouse {
	
	private int id;
	private String name;
	private String name2;
	
	public String getName2() {
		return name2;
	}
	public void setName2(String name2) {
		this.name2 = name2;
	}
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
	public Mouse() {
		// TODO Auto-generated constructor stub
	}
	

}
