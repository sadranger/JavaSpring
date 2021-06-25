package com.spring.dbconnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class ConnectDAOInit {
	
	private static Connection con = null;
	
	@SuppressWarnings("deprecation")
	public Mouse getMouse(int id) {
		
		//String driver = "org.apache.derby.jdbc.ClientDriver";
		try {
		//Class.forName(driver).newInstance();
		con = DriverManager.getConnection("jdbc:derby://localhost:1527/db");
		PreparedStatement ps = con.prepareStatement("select * from mouse where id= ?");
		ps.setInt(1, id);
	
		
		Mouse mouse = null;
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			mouse = new Mouse(id, rs.getString("name"));
		}
		rs.close();
		ps.close();
		return mouse;
		}
		catch(Exception e) {
			throw new RuntimeException(e);
		}
		finally {
			try {
			con.close();
			}catch(SQLException e) {System.out.println(e.toString());}
		}
	}

}
