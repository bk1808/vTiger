package com.comcast.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;
// FOR JDBC program we need to write methods withing try-catch block as there're chances of SQL exception if there's any syntax errors
public class DataBaseUtility {

	Connection conn;

	public void getDBConnection(String url, String un, String pwd) throws SQLException {

		try {
			Driver driverRef=new Driver();
			DriverManager.registerDriver(driverRef);
			conn=DriverManager.getConnection(url, un, pwd);
		}
		catch(Exception e) {
			System.out.println("===Connection Done===");
		}
	}

	//		This method is for internal team since we will have only one database we can hardcode this  
	public void getDBConnection() throws SQLException {

		try {
			Driver driverRef=new Driver();
			DriverManager.registerDriver(driverRef);
			conn=DriverManager.getConnection("mysql:jdbc://localhost:3306/db_projects", "root", "root");
		}
		catch(Exception e) {
			System.out.println("===Connection Done===");
		}
	}

	public void closeConnection() throws SQLException {
		conn.close();
	}

	public ResultSet executeSelectQuery(String query) throws SQLException {

		ResultSet result=null;

		try {
			Statement stat=conn.createStatement();
			result=stat.executeQuery(query);

		}
		catch(Exception e) {
			System.out.println("Exception handled");
		}

		return result;
	}

	public int executeNonSelectQuery(String query) throws SQLException {

		int result=0;

		try {
			Statement stat = conn.createStatement();
			result=stat.executeUpdate(query);
		}
		catch(Exception e) {
			System.out.println("===Updated===");
		}

		return result;

	}

}
