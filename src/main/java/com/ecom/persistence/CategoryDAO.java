package com.ecom.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ecom.model.Category;
import com.ecom.util.DBConnection;

public class CategoryDAO {
	private DBConnection dbConnection;
	
	public CategoryDAO(DBConnection dbConnection) {
		this.dbConnection = dbConnection;
	}
	
	public int create(Category category) {
		String sql = "insert into categories (title,status) values(?,?)";
		try(Connection con = dbConnection.createConnection();
				PreparedStatement pst = con.prepareStatement(sql)
				) {
			
			pst.setString(1, category.getTitle());
			pst.setString(2, category.getStatus());
			
			return pst.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public ArrayList<Category> getCategories() {
		String sql = "select * from categories";
		try(Connection con = dbConnection.createConnection();
				PreparedStatement pst = con.prepareStatement(sql)
				) {
			ResultSet rs = pst.executeQuery();
			ArrayList<Category> categoryList = new ArrayList<Category>();
			Category category;
			while(rs.next()) {
				category = new Category();
				category.setId(rs.getInt("id"));
				category.setTitle(rs.getString("title"));
				category.setStatus(rs.getString("status"));
				category.setCreatedAt(rs.getDate("created_at"));
				category.setUpdatedAt(rs.getDate("updated_at"));
				
				categoryList.add(category);
			}
			return categoryList;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
