package com.ecom.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ecom.model.Admin;
import com.ecom.util.DBConnection;

public class AdminDao {
	private DBConnection dbConnection;
	
	public AdminDao(DBConnection dbConnection) {
		this.dbConnection = dbConnection;
	}
	
	public Admin authenticate(String email, String password) {
		// Create query
		String sql = "select id,name,email,mobile,status from admins where email = ? and password  = ?";
		
		try(Connection con = dbConnection.createConnection();
			PreparedStatement pst = con.prepareStatement(sql)) {
			pst.setString(1, email);
			pst.setString(2, password);
			ResultSet rs = pst.executeQuery();
			
			if(rs.next()) {
				return new Admin(
						rs.getInt("id"), 
						rs.getString("name"),
						rs.getString("email"), 
						rs.getString("mobile"), 
						rs.getString("status")
				);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public int updateProfile(Admin admin) {
		String query = "update admins set name = ?, mobile = ? where id = ?";
		
		try(Connection con = dbConnection.createConnection();
				PreparedStatement pst = con.prepareStatement(query)
				) {
			pst.setString(1, admin.getName());
			pst.setString(2, admin.getMobile());
			pst.setInt(3, admin.getId());
			
			return pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
}
