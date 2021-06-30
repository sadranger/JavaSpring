package com.spring.dbconnectspring;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

public class NamedJdbcTemplate extends NamedParameterJdbcDaoSupport {
	
	public List<Mouse> getRows(int id, String name){
		String st = "select * from mouse where id=:id and name=:name";
		SqlParameterSource parameters = new MapSqlParameterSource()
											.addValue("name", name)
											.addValue("id", id);
		return this.getNamedParameterJdbcTemplate().query(st, parameters, new MouseMapper());
	}
	
	private static final class MouseMapper implements RowMapper<Mouse>{

		public Mouse mapRow(ResultSet rs, int rowNum) throws SQLException {
			Mouse ms = new Mouse();
			ms.setId(rs.getInt("id"));
			ms.setName(rs.getString("name"));
			ms.setName2(rs.getString("name2"));
			return ms;
		}
		
	}

}
