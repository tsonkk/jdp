package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

import daos.CustomerDAO;
import entities.Customer;

@WebServlet("/CustomerServlet")
public class CustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		// action=list
		if ("list".equalsIgnoreCase(action)) {
			List<Customer> custs = CustomerDAO.getAll();
			request.setAttribute("custs", custs);
			request.getRequestDispatcher("listcustomer.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		// action=add
		if ("add".equalsIgnoreCase(action)) {
			int id = Integer.parseInt(request.getParameter("txtID"));
			String name = request.getParameter("txtName");
			int age = Integer.parseInt(request.getParameter("txtAge"));
			Customer newCust = new Customer(id, name, age);
			CustomerDAO.insert(newCust);
			response.sendRedirect("?action=list");
		}
		// action=update
		else if ("update".equalsIgnoreCase(action)) {
			int id = Integer.parseInt(request.getParameter("txtID"));
			String name = request.getParameter("txtName");
			int age = Integer.parseInt(request.getParameter("txtAge"));
			Customer newCust = new Customer(id, name, age);
			CustomerDAO.update(newCust);
			response.sendRedirect("?action=list");
		}
		// action=delete
		else if ("delete".equalsIgnoreCase(action)) {
			int id = Integer.parseInt(request.getParameter("txtID"));
			CustomerDAO.delete(id);
			response.sendRedirect("?action=list");
		}
	}

}