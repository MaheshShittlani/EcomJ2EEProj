package com.ecom.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	static {
		try {
			Class.forName(DBConfig.DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Connection createConnection() {
		try {
			Connection con =  DriverManager.getConnection(
					DBConfig.CONNECTION_URL,
					DBConfig.USERNAME,
					DBConfig.PASSWORD);
			return con;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void closeConnection(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
