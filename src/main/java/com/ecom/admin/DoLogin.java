package com.ecom.admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.ecom.business.Admin;
import com.ecom.model.AdminModel;

/**
 * Servlet implementation class DoLogin
 */
@WebServlet("/admin/login")
public class DoLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		HttpSession session = request.getSession();
		String redirectURL = "";
		
		if(AdminModel.authenticate(email, password)) {
			redirectURL = "admin/dashboard.jsp";
		} else {
			redirectURL = "index.jsp";
			session.setAttribute("msg", "Invalid username/password");
		}
		response.sendRedirect(redirectURL);
	}

}
