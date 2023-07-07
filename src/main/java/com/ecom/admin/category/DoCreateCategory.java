package com.ecom.admin.category;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.HashMap;

import com.ecom.model.Category;
import com.ecom.persistence.CategoryDAO;
import com.ecom.util.DBConnection;

/**
 * Servlet implementation class DoCreateCategory
 */
@WebServlet("/admin/category/store")
public class DoCreateCategory extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DBConnection dbConnection;
    private CategoryDAO categoryDAO;
    
	@Override
	public void init() throws ServletException {
		super.init();
		dbConnection = new DBConnection();
		categoryDAO = new CategoryDAO(dbConnection);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Fetch data from request
		String title = request.getParameter("title");
		String status = request.getParameter("status");
		
		HttpSession session = request.getSession();
		// Validation
		HashMap<String, String> errors = new HashMap<String, String>();
		if(title.isEmpty()) {
			errors.put("title", "Category title required");
		}
		
		if(status.isBlank()) {
			errors.put("status", "Status is required");
		} else if(!(status.equals("Active") || status.equals("Inactive"))){
			errors.put("status", "Invalid status");
		}
		
		String redirectURL = request.getServletContext().getContextPath()+"/admin/category";
		if(!errors.isEmpty()) {
			session.setAttribute("errors", errors);
			redirectURL = "create.jsp";
		}
		
		
		Category category = new Category(title,status);
		
		int updateCount = categoryDAO.create(category);
		if(updateCount != 0) {
			session.setAttribute("msg", "Category created Successfully");
		} else {
			session.setAttribute("msg", "Category can't be created");
		}
		
		response.sendRedirect(redirectURL);
	}

}
