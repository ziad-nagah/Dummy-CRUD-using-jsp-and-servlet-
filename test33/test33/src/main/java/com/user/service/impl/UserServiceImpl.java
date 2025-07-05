package com.user.service.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.user.model.User;
import com.user.service.UserService;

public class UserServiceImpl implements UserService {
	
	private DataSource dataSource;
	
	public UserServiceImpl(DataSource dataSource){
		this.dataSource = dataSource;
	}
	@Override
	public boolean signIn(User user) {
		String userName = user.getUserName();
		String password = user.getPassword();
		try {
			Connection connection = dataSource.getConnection();
			String query = "SELECT USERNAME FROM USERS WHERE USERNAME = '" + userName+"'";
			String query2 = "INSERT INTO USERS (USERNAME , PASSWORD ) VALUES ('"+userName+"' ,'"+password+"')";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			if(resultSet.next()){
				return false;
			}
			int res = statement.executeUpdate(query2);
			
			return res == 1;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return false;
	
		}
	

	@Override
	public boolean logIn(User user) {
		String userName = user.getUserName();
		String password = user.getPassword();
		try {
			Connection connection = dataSource.getConnection();
			String query = "SELECT USERNAME FROM USERS WHERE USERNAME = '" + userName+"' AND PASSWORD = '"+password+"'";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			if(resultSet.next()){
				return true;
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return false;
	}
	
	

}
