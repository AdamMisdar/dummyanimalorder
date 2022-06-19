package com.qurban.dao; // Data Access Object
import java.sql.*;

// This DAO class provides CRUD database operations for the table Committee in the database
public class CommitteeDAO {
	
	// Connector
	Connection connection = null;
	
	//Defining final SQL Statements
	private static final String INSERT_NEW_COMMITTEE = 
	"INSERT INTO committee" + "(committeeName, committeeFullName, committeePhoneNum, "
							+ "committeeBirthDate, committeeAddress) " 
							+ "VALUES (?, ?, ?, ?, ?);";
	
	//private static final String SELECT;
}
