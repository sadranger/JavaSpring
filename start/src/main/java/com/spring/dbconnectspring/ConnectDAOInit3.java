package com.spring.dbconnectspring;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class ConnectDAOInit3 {
	@Autowired
	private DataSource dataSource;
	
	private static Connection con = null;
	
	@SuppressWarnings("deprecation")
	public Mouse getMouse(int id, String name) {
		
		//String driver = "org.apache.derby.jdbc.ClientDriver";
		try {
		//Class.forName(driver).newInstance();
		
		con = dataSource.getConnection();
		PreparedStatement select = con.prepareStatement("select * from mouse where id= ? and name= ?");
		PreparedStatement insert = con.prepareStatement("insert into mouse values(?,?,?)");
		select.setInt(1, id);
		select.setString(2, name);
		insert.setInt(1, 3);
		insert.setString(2,"custom String");
		insert.setString(3, "Test Insert");
	
		
		Mouse mouse = null;
		int rsInsert = insert.executeUpdate();
		System.out.println(rsInsert);
		ResultSet rs = select.executeQuery();
		if(rs.next()) {
			mouse = new Mouse(id, rs.getString("name"));
		}
		rs.close();
		select.close();
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
	
	public DataSource getDataSource() {
		return dataSource;
	}
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

}
