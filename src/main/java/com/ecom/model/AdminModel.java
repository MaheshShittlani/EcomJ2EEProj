package com.ecom.model;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminModel {
	
	public static boolean authenticate(String email, String password) {
		String sql = "select * from admins where email = '"+email+"' and password = '"+password+"'";
		try {
			ResultSet rs = DBCommon.executeSQL(sql);
			if(rs.next()) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
