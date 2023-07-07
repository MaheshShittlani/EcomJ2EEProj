package com.ecom.admin;

import java.io.IOException;

import com.ecom.model.Admin;
import com.ecom.persistence.AdminDao;
import com.ecom.util.DBConnection;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class DoUpdateProfile
 */
@WebServlet("/admin/updateProfile")
public class DoUpdateProfile extends HttpServlet {
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
		HttpSession session = request.getSession();
		Admin sessionAdmin = (Admin)session.getAttribute("admin");
		if(sessionAdmin == null) {
			response.sendRedirect("index.jsp");
			return;
		}
		
		int id = sessionAdmin.getId();
		String name = request.getParameter("name");
		String mobile = request.getParameter("mobile");
		
		Admin admin = new Admin();
		admin.setId(id);
		admin.setName(name);
		admin.setEmail(sessionAdmin.getEmail());
		admin.setMobile(mobile);
		
		
		int updateCount = adminDao.updateProfile(admin);
		if(updateCount > 0) {
			session.setAttribute("admin", admin);
			session.setAttribute("msg", "Prifile updated successfully");
		} else {
			session.setAttribute("msg", "Prifile can\'t be updated");
		}
		response.sendRedirect("change-profile.jsp");
	}

}
