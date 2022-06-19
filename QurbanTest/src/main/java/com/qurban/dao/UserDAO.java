package com.qurban.dao;

import java.sql.*;
import java.util.*;

import com.qurban.connection.ConnectionPool;
import com.qurban.javabean.*;

//This DAO class provides CRUD database operations for the table Committee in the database
public class UserDAO {
	
	//Defining final SQL Statements
	private static final String INSERT_USERS_SQL = // Insert new user
	"INSERT INTO committee(name, email, country) " +
	"VALUES (?, ?, ?);";
	
	private static final String SELECT_USER_BY_ID = // Select 1 user by id
	"SELECT id, name, email, country " +
	"FROM users " +
	"WHERE id = ?;";
	
	private static final String SELECT_ALL_USERS = // Select all users
	"SELECT * " +
	"FROM users;";
	
	private static final String DELETE_USERS_SQL = // Delete 1 user by id
	"DELETE * " +
	"FROM users " +
	"WHERE id = ?;";
	
	private static final String UPDATE_USERS_SQL = // Update 1 user by id
	"UPDATE users " +
	"SET name = ?, email = ?, country = ? " +
	"WHERE id = ?;";
	
	// Create or insert user
	public void insertUser(User user) {
		
		try(
			//Connect to database
			Connection connection = ConnectionPool.getInstance().getConnection();
			
			// Make PreparedStatement
			PreparedStatement sqlCreate = connection.prepareStatement(INSERT_USERS_SQL); ) // close try()
			
			{
			// Set ? values in sql statement
			sqlCreate.setString(1, user.getName());
			sqlCreate.setString(2, user.getEmail());
			sqlCreate.setString(3, user.getCountry());
			
			// Execute SQL
			sqlCreate.executeUpdate();
			
			
		} // close try{}
		
		catch(Exception e) {
			e.printStackTrace();
		}
		
	} // end of Create User ------------------------------------------------------------------------------
	
	// Update user - returns true when rows are updated
	public boolean updateUser(User user) throws SQLException {
		boolean rowUpdated = false;
		try( 
			// Connect to database
			Connection connection = ConnectionPool.getInstance().getConnection();
			
			// Make PreparedStatement
			PreparedStatement sqlUpdate = connection.prepareStatement(UPDATE_USERS_SQL); ) // close try()
			
			{
			// Set ? values in sql statement
			sqlUpdate.setString(1, user.getName());
			sqlUpdate.setString(2, user.getEmail());
			sqlUpdate.setString(3, user.getCountry());
			sqlUpdate.setInt(4, user.getId());
			
			rowUpdated = sqlUpdate.executeUpdate() > 0;
			
		} // close try{}
		
		catch(Exception e) {
			e.printStackTrace();
		} 	
		return rowUpdated;
		
	} // end of Update User ------------------------------------------------------------------------------
	
	// Select user by id - returns 1 user
	public User selectUser(int id) throws SQLException {
		User user = null;

		try(
			// Step 1: Establishing a Connection
			Connection connection = ConnectionPool.getInstance().getConnection();
				
			// Step 2 : Make PreparedStatement
			PreparedStatement sqlSelectUser = connection.prepareStatement(SELECT_USER_BY_ID); ) // close try()
			{
			// Set ? values in sql statement
			sqlSelectUser.setInt(1, id);
			
			// Step 3: Execute the query or update query
			ResultSet result = sqlSelectUser.executeQuery();
			
			// Step 4: Process the ResultSet object
			while(result.next()) {
				String name = result.getString("name");
				String email = result.getString("email");
				String country = result.getString("country");
				user = new User(id, name, email, country);
			}
		} // close try{}
		
		catch(SQLException e) {
			e.printStackTrace();
		}
		return user;
		
	} // end of Select 1 User ------------------------------------------------------------------------------
	
	// Select all users - returns a list of all users
	public List<User> selectAllUsers() throws SQLException {
		List<User> userList = new ArrayList<>();
		
		try(
			// Step 1: Establishing a Connection
			Connection connection = ConnectionPool.getInstance().getConnection();
				
			// Step 2 : Make PreparedStatement
			PreparedStatement sqlSelectAllUser = connection.prepareStatement(SELECT_ALL_USERS); ) // close try()
			{
			System.out.println(sqlSelectAllUser);
			
			// Step 3: Execute the query or update query
			ResultSet result = sqlSelectAllUser.executeQuery();
			
			// Step 4: Process the ResultSet object
			while(result.next()) {
				int id = result.getInt("id");
				String name = result.getString("name");
				String email = result.getString("email");
				String country = result.getString("country");
				userList.add(new User(id, name, email, country));
			} 
		} // close try{}
		
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return userList;
		
	} // end of Select all User ------------------------------------------------------------------------------
	
	// Delete user
	public boolean deleteUser(int id) throws SQLException {
		boolean rowDeleted = false;
		
		try(
			// Step 1: Establishing a Connection
			Connection connection = ConnectionPool.getInstance().getConnection();
					
			// Step 2 : Make PreparedStatement
			PreparedStatement sqlDelete = connection.prepareStatement(DELETE_USERS_SQL); ) // close try()
			{
			sqlDelete.setInt(1, id);
			
			rowDeleted = sqlDelete.executeUpdate() > 0;
			
		} // close try{}
		
		catch(SQLException e) {
			e.printStackTrace();
		}
		return rowDeleted;
		
	} // end of Delete user ------------------------------------------------------------------------------
	

	
}