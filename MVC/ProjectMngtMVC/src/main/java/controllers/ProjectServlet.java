package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import daos.EmployeeDAO;
import daos.ProjectDAO;
import entities.Employee;
import entities.Project;

@WebServlet("/ProjectServlet")
public class ProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		// action=list
		if ("list".equalsIgnoreCase(action)) {
			List<Project> projs = ProjectDAO.getAll();
			request.setAttribute("projs", projs);
			request.getRequestDispatcher("dangde2.jsp").forward(request, response);
		}
		// action=listemp
		else if ("listemp".equalsIgnoreCase(action)) {
			int projID = Integer.parseInt(request.getParameter("projID"));
			Project proj = ProjectDAO.getDetails(projID);
			request.setAttribute("proj", proj);
			List<Employee> emps = EmployeeDAO.getByProjID(projID);
			request.setAttribute("emps", emps);
			request.getRequestDispatcher("listemployee.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		// action=add
		if ("add".equalsIgnoreCase(action)) {
			String name = request.getParameter("txtName");
			String strDate = request.getParameter("dtDeadline");
			System.out.println("ProjectServlet: " + strDate); // yyyy-MM-dd
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date deadline = new Date();
			try {
				deadline = sdf.parse(strDate);
			} catch (ParseException ex) { ex.printStackTrace(); }
			Project newProj = new Project(0, name, deadline);
			ProjectDAO.insert(newProj);
			response.sendRedirect("?action=list");
		}
	}

}