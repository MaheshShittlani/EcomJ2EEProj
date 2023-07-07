package com.ecom.admin.category;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import com.ecom.model.Category;
import com.ecom.persistence.CategoryDAO;
import com.ecom.util.DBConnection;

/**
 * Servlet implementation class ListCategory
 */
@WebServlet("/admin/category")
public class ListCategory extends HttpServlet {
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
     * @see HttpServlet#HttpServlet()
     */
    public ListCategory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Category>categoryList = categoryDAO.getCategories();
		request.setAttribute("list", categoryList);	
		RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/admin/category/list.jsp");
		dispatcher.forward(request, response);
		
	}
}
