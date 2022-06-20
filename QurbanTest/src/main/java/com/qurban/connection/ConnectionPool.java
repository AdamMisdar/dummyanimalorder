package com.qurban.connection;

import java.sql.*;

public class ConnectionPool {
	
	private ConnectionPool() {
		
	}
	
	// Connection instance
	private Connection connection = getConnection();
	
	private static ConnectionPool instance = null;
	
	public static ConnectionPool getInstance(){
		if (instance==null)
			instance = new ConnectionPool();
		return instance;
	}
	
	/**
	 * Getting connection from connection pool.
	 *
	 * @see ConnectionPool
	 * @throws SQLException
	 */
	
	public Connection getConnection() {

		try {
			Class.forName("org.postgresql.Driver").newInstance();
		} catch (InstantiationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String username = "postgres";
		String password = "system";
		String dbUrl = "jdbc:postgresql://"
						+ "localhost:5432"
						+ "/QurbanDAOTest"; // '?sslmode=require' : it's to connect to the database from our machine
		
		try {
			return DriverManager.getConnection(dbUrl, username, password);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return connection;
		}
}
