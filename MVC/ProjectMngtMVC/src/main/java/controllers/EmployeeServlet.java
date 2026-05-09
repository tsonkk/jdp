package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import daos.EmployeeDAO;
import daos.ProjectDAO;
import entities.Employee;
import entities.Project;

@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		// action=list
		if ("list".equalsIgnoreCase(action)) {
			List<Project> projs = ProjectDAO.getAll();
			request.setAttribute("projs", projs);
			List<Employee> emps = EmployeeDAO.getAll();
			request.setAttribute("emps", emps);
			request.getRequestDispatcher("dangde1.jsp").forward(request, response);
		}
		// action=delete
		else if ("delete".equalsIgnoreCase(action)) {
			int id = Integer.parseInt(request.getParameter("id"));
			EmployeeDAO.delete(id);
			response.sendRedirect("?action=list");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		// action=add
		if ("add".equalsIgnoreCase(action)) {
			String fullname = request.getParameter("txtFullname");
			boolean gen = Boolean.parseBoolean(request.getParameter("rdbGen"));
			int projID = Integer.parseInt(request.getParameter("cmbProjID"));
			Employee newEmp = new Employee(0, fullname, gen, projID);
			EmployeeDAO.insert(newEmp);
			response.sendRedirect("?action=list");
		}
	}

}