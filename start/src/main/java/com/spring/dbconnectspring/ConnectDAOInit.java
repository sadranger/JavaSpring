package com.spring.dbconnectspring;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;


@Component
public class ConnectDAOInit {
	
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedJdbcTemplate;
	//private SimpleJdbcTemplate simpleJdbcTemplate;
	
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
	
	
	
	public int getCountRows(int circleId) {
		String st = "SELECT count(*) from mouse";
		String st2 = "select name from mouse where id=?";
		List<String> ar = jdbcTemplate.queryForList(st2, String.class, new Object[] {circleId});
		System.out.println("Returned Strings");
		for(String a: ar)
			System.out.println(a);
		return jdbcTemplate.queryForObject(st,Integer.class);
		//return jdbcTemplate.queryForObject(st2,String.class, new Object[] {circleId,"Right Click"});
	}
	
	public List<Mouse> getWholeRecords(int id){
		String st = "select * from mouse where id=3";
		return jdbcTemplate.query(st, new MouseMapper());
		
	}
	
	/*
	 * public void insertTable(int id, String name) { String st =
	 * "insert into mouse values(?,?,?)"; jdbcTemplate.update(st, new Object[]
	 * {id,name,"custom"}); System.out.println("inserted!!"); }
	 */
	
	public void insertTable(int id, String name) {
		String st = "insert into mouse values(:id,:name,:name2)";
		SqlParameterSource sqlParameter = new MapSqlParameterSource("id",id)
											.addValue("name", name)
											.addValue("name2", "Custom Named Test");
		namedJdbcTemplate.update(st, sqlParameter);
		System.out.println("inserted!!");
	}
	
	public DataSource getDataSource() {
		return dataSource;
	}
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.namedJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
		this.dataSource = dataSource;
	}

	/*
	 * public JdbcTemplate getJdbcTemplate() { return jdbcTemplate; }
	 * 
	 * public void setJdbcTemplate(JdbcTemplate jdbcTemplate) { this.jdbcTemplate =
	 * jdbcTemplate; }
	 */
	 
	
	//Server=localhost\SQLEXPRESS;Database=master;Trusted_Connection=True;
	
	private static final class MouseMapper implements RowMapper<Mouse>{

		public Mouse mapRow(ResultSet rs, int rowNum) throws SQLException {
			Mouse ms = new Mouse();
			ms.setId(rs.getInt("ID"));
			ms.setName(rs.getString("name"));
			ms.setName2(rs.getString("name2"));
			return ms;
			
		}
		
		
	}

}
