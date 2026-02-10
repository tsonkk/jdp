package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import daos.CategoryDAO;
import daos.ProductDAO;
import entities.Category;
import entities.Product;

@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		// action=list
		if ("list".equalsIgnoreCase(action)) {
			int catID = Integer.parseInt(request.getParameter("catID"));
			List<Product> prods = ProductDAO.getByCatID(catID);
			request.setAttribute("prods", prods);
			request.getRequestDispatcher("listproduct.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		// action=add
		if ("add".equalsIgnoreCase(action)) {
			int id = Integer.parseInt(request.getParameter("txtID"));
			String name = request.getParameter("txtName");
			int price = Integer.parseInt(request.getParameter("txtPrice"));
			int catID = Integer.parseInt(request.getParameter("catID"));
			Product newProd = new Product(id, name, price, catID);
			boolean result = ProductDAO.insert(newProd);
			response.sendRedirect("?action=list&catID=" + catID);
		}
		// action=update
		else if ("update".equalsIgnoreCase(action)) {
			int id = Integer.parseInt(request.getParameter("txtID"));
			String name = request.getParameter("txtName");
			int price = Integer.parseInt(request.getParameter("txtPrice"));
			int catID = Integer.parseInt(request.getParameter("catID"));
			Product newProd = new Product(id, name, price, catID);
			boolean result = ProductDAO.update(newProd);
			response.sendRedirect("?action=list&catID=" + catID);
		}
		// action=delete
		else if ("delete".equalsIgnoreCase(action)) {
			int id = Integer.parseInt(request.getParameter("txtID"));
			int catID = Integer.parseInt(request.getParameter("catID"));
			boolean result = ProductDAO.delete(id);
			response.sendRedirect("?action=list&catID=" + catID);
		}
	}

}