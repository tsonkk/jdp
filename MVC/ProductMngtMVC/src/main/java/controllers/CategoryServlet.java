package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import daos.CategoryDAO;
import entities.Category;

@WebServlet("/CategoryServlet")
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		// action=list
		if ("list".equalsIgnoreCase(action)) {
			List<Category> cats = CategoryDAO.getAll();
			request.setAttribute("cats", cats);
			request.getRequestDispatcher("listcategory.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		// action=add
		if ("add".equalsIgnoreCase(action)) {
			int id = Integer.parseInt(request.getParameter("txtID"));
			String name = request.getParameter("txtName");
			Category newCat = new Category(id, name);
			CategoryDAO.insert(newCat);
			response.sendRedirect("?action=list");
		}
		// action=update
		else if ("update".equalsIgnoreCase(action)) {
			int id = Integer.parseInt(request.getParameter("txtID"));
			String name = request.getParameter("txtName");
			Category newCat = new Category(id, name);
			CategoryDAO.update(newCat);
			response.sendRedirect("?action=list");
		}
		// action=delete
		else if ("delete".equalsIgnoreCase(action)) {
			int id = Integer.parseInt(request.getParameter("txtID"));
			CategoryDAO.delete(id);
			response.sendRedirect("?action=list");
		}
	}

}