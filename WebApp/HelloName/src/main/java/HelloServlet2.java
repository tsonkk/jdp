import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/HelloServlet2")
public class HelloServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  public HelloServlet2() {
    super();
  }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("txtFirstName");
    String lastName = request.getParameter("txtLastName");
    String fullName =  lastName.toUpperCase() + " " + firstName.toUpperCase();
    System.out.println("HelloServlet2: " + fullName); // for DEBUG
    request.setAttribute("fullName", fullName);
    request.getRequestDispatcher("welcome2.jsp").forward(request, response);
	}

}
