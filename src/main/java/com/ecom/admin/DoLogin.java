package com.ecom.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.HashMap;

import com.ecom.model.Admin;
import com.ecom.persistence.AdminDao;
import com.ecom.util.DBConnection;

/**
 * Servlet implementation class DoLogin
 */
@WebServlet("/admin/login")
public class DoLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DBConnection dbConnection;
	private AdminDao adminDao;
	@Override
	public void init() throws ServletException {
		super.init();
		dbConnection = new DBConnection();
		adminDao = new AdminDao(dbConnection);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		
		HashMap<String,String> errors = new HashMap<String, String>();
		if(email.isEmpty()) {
			errors.put("email", "Email required");
		} 
//		else if(!email.contains("@")){
//			errors.put("email", "Invalid email format");
//		}
		
		if(password.isEmpty()) {
			errors.put("password", "Password required");
		} else if(password.length() < 6) {
			errors.put("password", "Password must be atleast 6 characters long");
		}
		
		String redirectURL = "";
		
		if(!errors.isEmpty()) {
			session.setAttribute("errors", errors);
			redirectURL = "index.jsp";
		} else {
			Admin admin = adminDao.authenticate(email, password);
			if(admin!= null) {
				session.setAttribute("admin", admin);
				redirectURL = "dashboard.jsp";
			} else {
				redirectURL = "index.jsp";
				session.setAttribute("msg", "Invalid username/password");
			}
		}
		response.sendRedirect(redirectURL);
	}

}
