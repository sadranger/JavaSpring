package com.spring.dbconnect;

public class ConnectDBstart {

	public static void main(String[] args) {
		ConnectDAOInit co = new ConnectDAOInit();
		Mouse m = co.getMouse(2, "Left Click");
		System.out.println(m.getName());
	}

}
