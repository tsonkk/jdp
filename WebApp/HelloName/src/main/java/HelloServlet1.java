import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/HelloServlet1")
public class HelloServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  public HelloServlet1() {
    super();
  }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("txtFirstName");
    String lastName = request.getParameter("txtLastName");
    String fullName =  lastName.toUpperCase() + " " + firstName.toUpperCase();
    System.out.println("HelloServlet1: " + fullName); // for DEBUG
    PrintWriter out = response.getWriter();
    out.println("<body>");
    out.println("<h2>Hello " + fullName + "</h2>");
    out.println("</body>");
	}

}
