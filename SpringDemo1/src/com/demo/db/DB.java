package com.demo.db;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.demo.model.User;

@Component
public class DB {
	
	//DB class to dataSource
	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbc = new NamedParameterJdbcTemplate(dataSource);
	}


	public int insertUser(User user) {
		Map<String, Object> map = new HashMap<>();
		map.put("name", user.getName());
		map.put("username", user.getUsername());
		map.put("Emailid", user.getEmailid());
		map.put("password", user.getPassword());
		map.put("repassword", user.getRepassword());
		String sql = "insert into user_detail(name,username,Emailid,password,repassword) "
				+ "values(:name,:username, :Emailid, :password, :repassword)";
		return jdbc.update(sql, map);
	}

	public int updateUser(User user) {
		Map<String, Object> map = new HashMap<>();
		map.put("id", user.getId());
		map.put("password", user.getPassword());
		String sql = "update user_detail set password=:password where user.id=:id";
		return jdbc.update(sql, map);
	}

	public int deleteUser(User user) {
		Map<String, Object> map = new HashMap<>();
		map.put("id", user.getId());
		map.put("password", user.getPassword());
		String sql = "delete from user_detail where user.id=:id";
		return jdbc.update(sql, map);
	}

	public List<User> fetchAllUser() {
		RowMapper<User> mapper = new RowMapper<User>() {
			@Override
			public User mapRow(ResultSet rst, int rowNum) throws SQLException {
				User user = new User();
				user.setId(rst.getInt("id"));
				user.setName(rst.getString("name"));
				user.setUsername(rst.getString("username"));
				user.setEmailid(rst.getString("Emailid"));
				user.setPassword(rst.getString("password"));
				user.setRepassword(rst.getString("repassword"));
				return user;
			}
		};
		String sql = "select * from user_detail ";
		return jdbc.query(sql, mapper);
	}

}
