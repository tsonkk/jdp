package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import daos.AdminDAO;
import entities.Admin;

@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		// action=logout
		if ("logout".equalsIgnoreCase(action)) {
			HttpSession session = request.getSession();
			session.removeAttribute("admin");
			response.sendRedirect("index.html");
		}
	}
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		// action=login
		if ("login".equalsIgnoreCase(action)) {
			String username = request.getParameter("txtUsername");
			String password = request.getParameter("txtPassword");
			Admin admin = AdminDAO.getDetails(username);
			if (admin != null && admin.password.equals(password)) {
				HttpSession session = request.getSession();
				session.setAttribute("admin", admin);
				response.sendRedirect("CategoryServlet?action=list");
			} else {
				response.sendRedirect("index.html");
			}
		}
	}

}
