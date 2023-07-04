package com.ecom.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBCommon {
	static {
		try {
			Class.forName(DBConfig.DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static ResultSet executeSQL(String sql) throws SQLException {
		Connection con = DriverManager.getConnection(DBConfig.CONNECTION_URL, DBConfig.USERNAME, DBConfig.PASSWORD);
		Statement st =  con.createStatement();
		ResultSet rs =  st.executeQuery(sql);
		
		rs.close();
		st.close();
		con.close();
		return rs;
	}
	
	public static int executeUpdate(String sql) throws SQLException {
		Connection con = DriverManager.getConnection(DBConfig.CONNECTION_URL, DBConfig.USERNAME, DBConfig.PASSWORD);
		Statement st =  con.createStatement();
		int affectedRows =  st.executeUpdate(sql);
		
		st.close();
		con.close();
		return affectedRows;
	}
}
